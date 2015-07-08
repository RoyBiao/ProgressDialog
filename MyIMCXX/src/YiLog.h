/*
 * YiLog.h
 *
 *  Created on: May 4, 2014
 *      Author: saint
 */

#ifndef _YIIM_YILOG_H_
#define _YIIM_YILOG_H_

#include <iostream>
#include <cstdarg>

namespace yiim {

class YiLog {
public:
	YiLog(std::string tag);
	virtual ~YiLog();

	virtual void i(std::string msg, ...);
	virtual void d(std::string msg, ...);
	virtual void w(std::string msg, ...);
	virtual void e(std::string msg, ...);
	virtual void v(std::string msg, ...);
    
    virtual void vi(std::string msg, va_list ap);
	virtual void vd(std::string msg, va_list ap);
	virtual void vw(std::string msg, va_list ap);
	virtual void ve(std::string msg, va_list ap);
	virtual void vv(std::string msg, va_list ap);

	static YiLog & getInstance();

	static bool ENABLE_DEBUG;
	static bool ENABLE_INFO;
	static bool ENABLE_ERROR;
	static bool ENABLE_WARN;
	static bool ENABLE_VERBOSE;
private:
	static YiLog mInstance;
	std::string mTag;
};

}
#endif /* _YIIM_YILOG_H_ */
