//============================================================================
// Name        : MyIMCXX.cpp
// Author      : 
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include "YiCore.h"

using namespace std;
using namespace yiim;
int main() {
	YiLog::ENABLE_DEBUG = true;
	YiLog::ENABLE_ERROR = true;
	YiLog::ENABLE_INFO = true;
	YiLog::ENABLE_VERBOSE = true;
	YiLog::ENABLE_WARN = true;

	YiCore core;
	//core.setServer("115.28.150.238");
	core.setServer("121.42.15.91");
	core.setServerName("chyitech.com");
	core.setResource("PC");
	//core.setMsgReceipt(true);
	core.start();
	return 0;
}
