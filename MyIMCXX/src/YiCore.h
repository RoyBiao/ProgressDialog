#ifndef __YIIM_YICORE_H
#define __YIIM_YICORE_H
#include "YiCore.h"
#include "YiLog.h"
#include "client.h"
#include "connectionlistener.h"
#include "YiThreads.h"
#include "gloox.h"


namespace gloox {
class ConnectionListener;
class LogHandler;
class Client;
}

using namespace gloox;
namespace yiim {

class YiCore : public Thread{
public:
	YiCore();
	virtual ~YiCore();

	virtual void setServer(const std::string & server);
	virtual void setServerName(const std::string & name);
	virtual void setResource(const std::string & resource);
	virtual void setPort(int port);
	virtual int start();
private:

	YiCore(const YiCore &);

	Client * mClient;
	Mutex mMutex;
	int mPort;
	bool mIsConnected;
	std::string mServer;
	std::string mServerName;
	std::string mUserName;
	std::string mResource;
	std::string mPushToken;
	std::string mRequestId;

};

}
#endif
