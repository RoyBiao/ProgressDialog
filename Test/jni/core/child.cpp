/*
 * child.cpp
 *
 *  Created on: 2015年2月5日
 *      Author: feng
 */

#include "child.h"

void child::onConnect()
{
	cout<<"连接成功"<<endl;
}
void child::onDisConect()
{
 cout<<"连接断开"<<endl;
}
void child::onMessage(int cmd,std::string msg)
{
 cout<<"cmd="<<cmd<<"   body="<<msg<<endl;
}
void child::onReLogin()
{
	cout<<"正在断线重连"<<endl;
}
void child::onLoginFalse()
{
	cout<<"登录失败"<<endl;
}
void child::onLoginSuccess()
{
	cout<<"登录成功"<<endl;
}


