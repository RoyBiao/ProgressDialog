#include "YiCore.h"
#include "YiLog.h"
using namespace gloox;
using namespace std;
#include <iostream>

namespace yiim {

YiCore::YiCore() :
		mClient(NULL), mPort(5222), mIsConnected(false), Thread("YiCore") {
}

YiCore::~YiCore() {

}

/**
 * 设置服务器IP
 * @param server IP或域名
 */
void YiCore::setServer(const std::string & server) {
	AutoMutex _l(mMutex);
	mServer = server;
	if (mServerName.empty()) {
		mServerName = server;
	}
}

/**
 * 设置Xmpp ServerName
 * @param name ServerName
 */
void YiCore::setServerName(const std::string & name) {
	AutoMutex _l(mMutex);
	mServerName = name;
}

/**
 * 绑定用户资源
 * @param resource 资源名称
 */
void YiCore::setResource(const std::string & resource) {
	AutoMutex _l(mMutex);
	mResource = resource;
}

/**
 * 设置端口号
 * @param port 端口号
 */
void YiCore::setPort(int port) {
	AutoMutex _l(mMutex);
	mPort = port;
}
/**
 * 开始连接服务器
 */
int YiCore::start() {
	if (mServer.empty()) {
		return -1;
	}

//	if (NULL != mClient) {
//		stop();
//	}

	AutoMutex _l(mMutex);
	YiLog::getInstance().i("start");

	mClient = new Client(mServer, mServerName);
	mClient->setPort(mPort);
//	mClient->disco()->setVersion("YiIM", gloox::GLOOX_VERSION, "Android");
//	mClient->disco()->setIdentity("Client", "YiIM");
	return Thread::start();

}

}

