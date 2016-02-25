/*
 * NetWork.h
 *
 *  Created on: 2015-1-30
 *  类功能：网络通信层
 */

#include "NetWork.h"
#include <fcntl.h>
#include <errno.h>
#include <time.h>
#include <string.h>

using namespace std;

/*
 * 构造函数,初始化各成员变量
 * 无参
 * 无返回值
 * */
NetWork::NetWork() {
	m_BUF=new char[NET_PACKET_BUF_LENGTH];
	mRawDataHandler = new RawData();

	mbAlive = e_HeartNormal;
	m_BufFlag=1;

	memset(mSrvIP, 0, SERVER_IP_ADDER_LEN);
	memset(&mSrvPort, 0, 1);
}

/*
 * 析构函数,销毁线程,关闭socket连接
 * 无参
 * 无返回值
 * */
NetWork::~NetWork() {
	close(mSockd);
	mbAlive = e_HeartOver;

	pthread_kill(mRecvPID,SIGQUIT);
	pthread_kill(mPingPID,SIGQUIT);
	//释放类对象内存
	if(NULL != mRawDataHandler)
	{
		delete mRawDataHandler;
		mRawDataHandler = NULL;
	}
}

/*
 * 设置连接的服务器IP
 * 参数
 * -不可变 IP字符串
 * 无返回值
 * */
void NetWork::setSrvIP(const char* ip)
{
	memset(mSrvIP, 0, SERVER_IP_ADDER_LEN);
	strcpy(mSrvIP, ip);
}

/*
 * 设置服务器端口
 * 参数
 * -不可变 端口号
 * 无返回值
 * */
void NetWork::setSrvPort(const unsigned short int port)
{
	memset(&mSrvPort, 0, 1);
	mSrvPort = port;
}

/*
 * 非阻塞方式连接服务器，5秒内若收到服务器回应，则返回给业务层，否则，5秒过后告诉业务层超时
 * 参数
 * -心跳包
 * 返回值
 * -0 成功
 * -1 失败
 * */
int NetWork::connectSrv()
{
		//ping包长度
		unsigned int bagLen = 0;
		//收到的包的CMD编号
		unsigned int cmdNo;
		//收到封包解出的JSON串
		std::string json="";
		//连接结果,0表示成功
		int rltNo = -1;
		//创建套接字
	    if((mSockd = socket(AF_INET,SOCK_STREAM,0))==-1)
	    {
	    	//告诉业务层本地网络错误
	    	//CONNECT_SERVER_LOCAL_ERROR
	    }
	    //设置非阻塞CONNECT
	    fcntl(mSockd, F_SETFL, fcntl(mSockd, F_GETFL, 0)|O_NONBLOCK);
	    //填充服务器地址
	    mServ_addr.sin_family = AF_INET;
	    mServ_addr.sin_port = htons(mSrvPort);
	    mServ_addr.sin_addr.s_addr = inet_addr(mSrvIP);
	    bzero(&(mServ_addr.sin_zero),8);

	    //首次非阻塞连接服务器
	    int cntNo = connect(mSockd,(struct sockaddr*)&mServ_addr,sizeof(struct sockaddr));
	    if((cntNo == -1)  && (errno != EINPROGRESS) )
	    {
	    	//告诉业务层本地网络错误
	    	//CONNECT_SERVER_LOCAL_ERROR
	    }

	    /*
	     * 开始验证是否物理连接上,发ping包。
	    *	在5秒内，每隔0.1秒向服务器发1个ping包
	    *	5秒内若收不到服务器返回ping包，则告诉业务层物理连接不成功
	    *	5秒内一旦收到返回，立刻停止发ping包，并告诉业务层物理连接成功，可以登录.
	    */
	    timeval tv;																			//select的超时时间
	    tv.tv_sec = 1;
	    tv.tv_usec = 0;
	    //发第一个ping包
	    int sendBatInterval = 0;
	    sendBatInterval += PING_SERVER_TIME_INTERVAL;
	    send(mSockd,mRawDataHandler->encode(e_Ping,"",&bagLen), bagLen, 0);
	   // 开始计时，发包，并检测收包情况
	    while(1)
	    {
	    	usleep(PING_SERVER_TIME_INTERVAL);
	    	FD_ZERO(&mRfds);
	    	FD_SET(mSockd,&mRfds);
	    	mMaxfd = MAX(0,mSockd)+1;

	    	//轮循检测是否有ping包返回
	    	select(mMaxfd,&mRfds,NULL,NULL,&tv);
	    	if(FD_ISSET(mSockd,&mRfds))
	    	{
	    		recv(mSockd,mRecvbuf,NET_PACKET_RECV_LENGTH,0);
	    		//收到服务器返回的ping包，立刻通知业务层已成功连接
	    		mRawDataHandler->decode(mRecvbuf, cmdNo, json);
	    		if(cmdNo == e_Ping)
	    		{
	    			//告诉业务层连接成功,同时设置为阻塞
	    			rltNo = 0;
	    			//fcntl(mSockd,F_SETFL,(fcntl(mSockd,F_GETFL,0) & ~O_NONBLOCK));
	    			this->m_Listener->onConnect();
	    			break;
	    		}
	    	}
	    	//累计间隔，并判断是否足够5秒，仍未收到服务器返回的ping包，继续发送ping包
	    	send(mSockd,mRawDataHandler->encode(e_Ping,"",&bagLen), bagLen, 0);
	    	sendBatInterval += PING_SERVER_TIME_INTERVAL;
	    	if(sendBatInterval >= LOGIN_SERVER_TIMEOUT_USEC)
	    	{
	    		//此处已满5秒，但未收到服务器的返回，则随后通知业务层连接服务器失败
	    		break;
	    	}//endif
	    }//endwhile
	    return rltNo;
}

/*
 * 断开服务器
 * 无参
 * 无返回值
 * */
void NetWork::disConnectSrv()
{
	this->m_Listener->onDisConect();
	close(mSockd);
	mbAlive = e_HeartOver;
	pthread_kill(mRecvPID,SIGQUIT);
	pthread_kill(mPingPID,SIGQUIT);
}
/*
 * 发送数据
 * 参数
 * -待发送的数据
 * 返回值
 * -发送数据成功,返回0,否则,返回-1
 * */
unsigned int NetWork::sendData(const char* data, unsigned int len)
{
	int flag = send(mSockd,data, len, 0);
	if(flag > 0)
	{
	      	return 0;
	}
	else
	{
			return -1;
	}
}

/*
 * 接收数据
 * 参数
 * -本类指针
 * 无返回值
 * */
void* NetWork::recvData(void* c)
{
	NetWork* p = (NetWork*)c;
	timeval tv;
	tv.tv_sec = 10;
	tv.tv_usec = 0;
	while(1)
	{
		int len;
		FD_ZERO(&p->mRfds);
		FD_SET(p->mSockd,&(p->mRfds));
		p->mMaxfd = MAX(0,p->mSockd)+1;

		//轮循检测是否有新的消息到来或者用户有输入
		select(p->mMaxfd,&(p->mRfds),NULL,NULL,&tv);
		//如果有新的消息到来则处理新来的消息
		if(FD_ISSET(p->mSockd,&p->mRfds))
		{
		    //清零接收缓冲区
			memset(p->mRecvbuf,0,NET_PACKET_RECV_LENGTH);
			//接收发过来的消息
			len=recv(p->mSockd,p->mRecvbuf,NET_PACKET_RECV_LENGTH,0);
			if(len == -1)
			{
				//如果接收失败则等待下一条消息的到来
				continue;
		    }
			p->recvToBUF(len);
		}//endif
	}//endwhile
	return (void*)0;
}

/*
 * 网络通信层的主函数
 * 无参
 * 无返回值
 * */
void NetWork::run()
{
	//接收数据的线程
	pthread_create(&(mRecvPID),NULL,recvData,(void*)this);
	//心跳包的线程
	pthread_create(&(mPingPID),NULL,hbFunc,(void*)this);
	return;
}

/*
 * 心跳功能 每次发心跳包前，会检查心跳状态：如果为false，则立刻更改发包间隔为10秒内随机值，并立刻发包；
 * 如果为true，则表示当前心跳正常，立刻发包。
 * 发完心跳包，将心跳状态置为false。
 * 当收到心跳返回时，会将该状态置为true，并将发包间隔改为正常值-15分钟。
 *
 * 参数
 * -本类指针
 * 无返回值
 * */
void* NetWork::hbFunc(void* c)
{
	NetWork* p = (NetWork*)c;
	unsigned int bagLen = 0;			//心跳包长度
	//起初心跳包间隔为15分钟,连接状态为true，表示活着
	p->mHBInterval = PING_HEART_BEAT_INTERVAL;
	p->mbAlive = e_HeartNormal;
	while(1)
	{
		//先检测心跳状态，如果级别在危险及以上，则更改心跳间隔，改为10秒内随机值，再发送
		//正常情况下,每隔900秒发一个心跳包
		//心跳包策略：如果15分钟内没收到服务器发回的心跳包，则立刻发送一个心跳包。
		//10以内的随机秒内若还未收到，则再发送一个心跳包。
		//第三个10以内的随机秒内还未收到，则重新建立连接，并通知业务层自己断线重连了.
		//发送完，开始等待，准备下次发送
		//正常					收到心跳包的立即状态
		if(e_HeartNormal == p->mbAlive)
		{
			p->mbAlive = e_HeartWait;
			p->mHBInterval = PING_HEART_BEAT_INTERVAL;
			send(p->mSockd,(p->mRawDataHandler)->encode(e_Ping,"",&bagLen), bagLen, 0);
			sleep(p->mHBInterval);
			continue;
		}
		//危險					发送此次心跳包之前，有一次没有收到心跳包
		else if(e_HeartDanger == p->mbAlive)
		{
			p->mbAlive = e_HeartEmerge;
			srand(time(NULL));
			p->mHBInterval = rand() % PING_RECONNECT_INTERVAL;
			send(p->mSockd,(p->mRawDataHandler)->encode(e_Ping,"",&bagLen), bagLen, 0);
			sleep(p->mHBInterval);
			continue;
		}
		//紧急					发送此次心跳包之前，有两次没有收到心跳包
		else if(e_HeartEmerge == p->mbAlive)
		{
			p->mbAlive = e_HeartOver;
			srand(time(NULL));
			p->mHBInterval = rand() % PING_RECONNECT_INTERVAL;
			send(p->mSockd,(p->mRawDataHandler)->encode(e_Ping,"",&bagLen), bagLen, 0);
			sleep(p->mHBInterval);
			continue;
		}
		//完蛋					发送此次心跳包之前，有三次没有收到心跳包，准备重连
		else if(e_HeartOver == p->mbAlive)
		{
			p->reConnectSrv();
			break;
		}
		//等待状态，变危险
		else
		{
			p->mbAlive = e_HeartDanger;
			p->mHBInterval = rand() % PING_RECONNECT_INTERVAL;
			send(p->mSockd,(p->mRawDataHandler)->encode(e_Ping,"",&bagLen), bagLen, 0);
			sleep(p->mHBInterval);
			continue;
		}
	}//endwhile
	return (void*)0;
}
void NetWork::recvToBUF(int len)
{
	int i;
	char *p=mRecvbuf;
	if(m_BufFlag==1)//收到第一个包
	{
		for(i=0;i<NET_PACKET_RECV_LENGTH;i++)
		{
			if((*p=='H')&&(*(p+1)=='S')&&(*(p+2)=='I'))
			{
				break;
			}
			p++;
		}
		if((*p=='H')&&(*(p+1)=='S')&&(*(p+2)=='I'));
		else
		{
			return;
		}
		m_PacketSize=*(unsigned int *)(p+3);
		if(m_PacketSize<=(len-i))
		memcpy(m_BUF,p,(len-i));
		else
		{
			m_BufFlag=0;
			memcpy(m_BUF,p,(len-i));
			m_HaveRecv=(len-i);
			return;
		}
	}
	else
	{
		memcpy(m_BUF,p,len);
		m_HaveRecv+=len;
		if(m_HaveRecv<m_PacketSize)
		{
			return;
		}
		else
		{
			m_BufFlag=1;
		}
	}
	string s;
	unsigned int cmd;
	(this->mRawDataHandler)->decode(m_BUF,cmd,s);
	//开始解包，根据cmd编号，进行逻辑处理分发
	switch(cmd)
	{
	//心跳包和数据包分别处理
	case e_Ping:
		this->mbAlive = e_HeartNormal;
		this->mHBInterval = PING_HEART_BEAT_INTERVAL;
		break;
	default:
		this->m_Listener->onMessage(cmd,s);
		break;
	};

}

int NetWork::relogin()
{
	string body="{\"username\":\"";
	body+=m_UserName;
    body+="\",\"password\":\"";
	body+=m_PassWord+"\"}";

	unsigned int length;
	char *p=this->mRawDataHandler->encode(e_Login,body.c_str(),&length);

	if(this->sendData(p,length)==0)
	 {
	   return 0;
	 }
	   return -1;
}

//断线重连
void NetWork::reConnectSrv()
{
	disConnectSrv();
	if(connectSrv()==0)
	{
			m_Listener->onConnect();
			m_Listener->onReLogin();
			if(relogin()==0)
			{
				m_Listener->onReLoginSuccess();
			}
			else
			{
				m_Listener->onReLoginFalse();
			}
	}
	else
	{
		m_Listener->onReLoginFalse();
	}
}
