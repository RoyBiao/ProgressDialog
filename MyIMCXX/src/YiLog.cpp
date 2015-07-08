/*
 * YiLog.cpp
 *
 *  Created on: May 4, 2014
 *      Author: saint
 */

#include "YiLog.h"

#ifdef OS_ANDROID
#include <android/log.h>
#else
#include <cstdio>
#endif

namespace yiim {

bool YiLog::ENABLE_DEBUG = false;
bool YiLog::ENABLE_INFO = false;
bool YiLog::ENABLE_ERROR = false;
bool YiLog::ENABLE_WARN = false;
bool YiLog::ENABLE_VERBOSE = false;

YiLog YiLog::mInstance("YiLog");

YiLog::YiLog(std::string tag) :
		mTag(tag) {
	// TODO Auto-generated constructor stub

}

YiLog::~YiLog() {
	// TODO Auto-generated destructor stub
}

YiLog & YiLog::getInstance() {
	return mInstance;
}

void YiLog::i(std::string msg, ...) {
	va_list ap;
	va_start(ap, msg);
    vi(msg, ap);
	va_end(ap);
}

void YiLog::d(std::string msg, ...) {
	va_list ap;
	va_start(ap, msg);
    vd(msg, ap);
	va_end(ap);
}

void YiLog::w(std::string msg, ...) {
	va_list ap;
	va_start(ap, msg);
    vw(msg, ap);
	va_end(ap);
}

void YiLog::e(std::string msg, ...) {
	va_list ap;
	va_start(ap, msg);
    ve(msg, ap);
	va_end(ap);
}

void YiLog::v(std::string msg, ...) {
	va_list ap;
	va_start(ap, msg);
    vv(msg, ap);
	va_end(ap);
}
    
void YiLog::vi(std::string msg, va_list ap) {
    if (!YiLog::ENABLE_INFO) {
		return;
	}
#ifdef OS_ANDROID
	__android_log_vprint(ANDROID_LOG_INFO, mTag.c_str(), msg.c_str(), ap);
#else
	printf("%s: ", mTag.c_str());
	vprintf(msg.c_str(), ap);
	printf("\n");
#endif
}

void YiLog::vd(std::string msg, va_list ap) {
    if (!YiLog::ENABLE_DEBUG) {
		return;
	}
#ifdef OS_ANDROID
	__android_log_vprint(ANDROID_LOG_DEBUG, mTag.c_str(), msg.c_str(), ap);
#else
	printf("%s: ", mTag.c_str());
	vprintf(msg.c_str(), ap);
	printf("\n");
#endif
}
    
void YiLog::vw(std::string msg, va_list ap) {
    if (!YiLog::ENABLE_WARN) {
		return;
	}
#ifdef OS_ANDROID
	__android_log_vprint(ANDROID_LOG_WARN, mTag.c_str(), msg.c_str(), ap);
#else
	printf("%s: ", mTag.c_str());
	vprintf(msg.c_str(), ap);
	printf("\n");
#endif
}

void YiLog::ve(std::string msg, va_list ap) {
    if (!YiLog::ENABLE_ERROR) {
		return;
	}
#ifdef OS_ANDROID
	__android_log_vprint(ANDROID_LOG_ERROR, mTag.c_str(), msg.c_str(), ap);
#else
	printf("%s: ", mTag.c_str());
	vprintf(msg.c_str(), ap);
	printf("\n");
#endif
}
    
void YiLog::vv(std::string msg, va_list ap) {
    if (!YiLog::ENABLE_VERBOSE) {
		return;
	}
#ifdef OS_ANDROID
	__android_log_vprint(ANDROID_LOG_VERBOSE, mTag.c_str(), msg.c_str(), ap);
#else
	printf("%s: ", mTag.c_str());
	vprintf(msg.c_str(), ap);
	printf("\n");
#endif
}

}
