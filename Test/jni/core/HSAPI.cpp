/*
 * NetWork.h
 *
 *  Created on: 2015-1-30
 *  类功能：暴露给业务层使用的接口
 */

#include "HSAPI.h"

HSAPI::HSAPI() {
	// TODO Auto-generated constructor stub
	m_NetWork=new NetWork();
}

HSAPI::~HSAPI() {
	// TODO Auto-generated destructor stub
	delete m_NetWork;
	m_NetWork=NULL;

}

int HSAPI::connect(std::string ip,unsigned short int port)
{
	this->m_NetWork->setSrvIP(ip.c_str());
	this->m_NetWork->setSrvPort(port);
	if(this->m_NetWork->connectSrv()==0)
	{
		this->m_NetWork->run();
		return 0;
	}
	else
		return -1;
}
void HSAPI::disconnect()
{
	this->m_NetWork->m_Listener->onDisConect();
}
void HSAPI::setListener(HSListener *listener)
{
	this->m_NetWork->m_Listener=listener;
}
int HSAPI::registerAccount(std::string username,std::string password,std::string nickname)
{
    string body="{\"username\":\"";
    body+=username;
    body+="\",\"password\":\"";
    body+=password+"\",\"nickname\":\"";
    body+=nickname+"\"}";

    unsigned int length;
    char *p=this->m_NetWork->mRawDataHandler->encode(e_Register,body.c_str(),&length);

    if(this->m_NetWork->sendData(p,length)==0)
    {
    	return 0;
    }
    return -1;
}
int HSAPI::login(std::string username,std::string password)
{
	string body="{\"username\":\"";
	body+=username;
    body+="\",\"password\":\"";
	body+=password+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_Login,body.c_str(),&length);

	if(this->m_NetWork->sendData(p,length)==0)
	 {
		this->m_NetWork->m_UserName=username;
		this->m_NetWork->m_PassWord=password;
	   return 0;
	 }
	   return -1;
}
int HSAPI::chat(std::string msg,std::string toname)
{
	string body="{\"body\":\"";
	body+=msg;
	body+="\",\"toname\":\"";
	body+=toname+"\",\"type\":\"chat\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_Chat,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::requestFriendsList(std::string username,std::string version)
{
	string body="{\"username\":\"";
	body+=username;
	body+="\",\"type\":\"both\",\"version\":\"";
	body+=version+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_RequestFriendsList,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::applyFriend(std::string username,std::string reason)
{
	string body="{\"username\":\"";
	body+=username;
	body+="\",\"reason\":\"";
    body+=reason+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_ApplyFriend,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::allow(std::string username)
{
	string body="{\"username\":\"";
	body+=username+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_Allow,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::refuse(std::string username,std::string reason)
{
	string body="{\"username\":\"";
	body+=username;
	body+="\",\"reason\":\"";
	body+=reason+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_Refuse,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::removeFriend(std::string username)
{
	string body="{\"username\":\"";
	body+=username+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_RemoveFriend,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::addMemo(std::string username,std::string memo)
{
	string body="{\"username\":\"";
	body+=username;
	body+="\",\"memo\":\"";
	body+=memo+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_AddMemo,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::updataGroup(std::string username,std::string group)
{
	string body="{\"username\":\"";
	body+=username;
	body+="\",\"group\":\"";
	body+=group+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_UpdataGroup,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::updataInfo(std::string nickname,std::string headportrait,std::string signature,std::string age,std::string gender)
{
	string body="{\"nickname\":\"";
	body+=nickname;
	body+="\",\"headportrait\":\"";
	body+=headportrait+"\",\"signature\":\"";
	body+=signature+"\",\"age\":\"";
	body+=age+"\",\"gender\":\"";
	body+=gender+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_UpdataInfo,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::changePWD(std::string PWD)
{
	string body="{\"PWD\":\"";
	body+=PWD+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_ChangePWD,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
int HSAPI::getUserInfo(std::string username)
{
	string body="{\"username\":\"";
	body+=username+"\"}";

	unsigned int length;
	char *p=this->m_NetWork->mRawDataHandler->encode(e_GetUserInfo,body.c_str(),&length);
	if(this->m_NetWork->sendData(p,length)==0)
	{
	    return 0;
	}
	return -1;
}
