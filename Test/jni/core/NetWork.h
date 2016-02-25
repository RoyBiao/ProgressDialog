/*
 * NetWork.h
 *
 *  Created on: 2015-1-30
 *  类功能：网络通信层
 */

#ifndef NETWORK_H_
#define NETWORK_H_

#include		<stdio.h>
#include		<stdlib.h>
#include		<string.h>
#include		<netdb.h>
#include		<termios.h>
#include		<sys/types.h>
#include		<netinet/in.h>
#include		<sys/socket.h>
#include		<arpa/inet.h>
#include		<unistd.h>
#include 		<stddef.h>
#include		<time.h>
#include 		<pthread.h>
#include		<signal.h>

#include 		"MacroDef.h"
#include		"RawData.h"
#include		"HSListener.h"

class RawData;
class NetWork {

public:
	NetWork();
	virtual 					~NetWork();

	void 						setSrvIP(const char* ip);																			//设置服务器IP
	void 						setSrvPort(const unsigned short int port);									//设置服务器端口
	int 							connectSrv();																									//连接服务器
	void						disConnectSrv();																							//断开服务器
	void 						run();																													//开始运行
	unsigned int 	sendData( const char* data, unsigned len);									//发送
	void						recvToBUF(int len);																										//将接收到到数据送到总缓冲区进一步处理
	int 							relogin();
	void 						reConnectSrv();																									//重连

public:
	static void* 		recvData(void* c);
	static void*		hbFunc(void* c);

public:
	pthread_t 	mRecvPID;																											//收数据线程ID
	pthread_t		mPingPID;																											//心跳包线程ID
	RawData*	mRawDataHandler;																							//处理数据的类指针
	HSListener  *m_Listener;
	std::string m_UserName;
	std::string m_PassWord;

private:
	char 				mSrvIP[SERVER_IP_ADDER_LEN];																//服务器IP
	unsigned short int  		mSrvPort;																					//服务器端口号
	struct sockaddr_in 			mServ_addr;																				//定义服务端网络地址
	 int 				mSockd;																												//创建的套接字
	 int 				mMaxfd;																												//描述符最大轮循范围
	 fd_set 			mRfds;																													//定义轮循fd_set
	 char 			mRecvbuf[NET_PACKET_RECV_LENGTH];													//定义接收缓冲区
	 char				*m_BUF;
	 unsigned int	mHBInterval;																								//当前心跳包策略间隔
	 unsigned int	mbAlive;																										//当前连接心跳状态
	 int					m_BufFlag;
	 int					m_HaveRecv;
	 int					m_PacketSize;
};


#endif /* NETWORK_H_ */
