/*
 * HSListener.h
 * 监听类，用来给业务层继承，从而实现具体功能
 *
 */

#ifndef SRC_HSLISTENER_H_
#define SRC_HSLISTENER_H_
#include "string"
using namespace std;
class HSListener
{
public:
	//连接成功的回调
	virtual void onConnect()=0;
	//连接失败的回调
	virtual void onDisConect()=0;
	//收到消息的回调
	virtual void onMessage(int cmd,std::string msg)=0;
	//正在重新登录的回调
	virtual void onReLogin()=0;
	//重新登录失败的回调
	virtual void onReLoginFalse()=0;
	//重新登陆成功的回调
	virtual void onReLoginSuccess()=0;
};




#endif /* SRC_HSLISTENER_H_ */
