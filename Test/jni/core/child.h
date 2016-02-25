/*
 * child.h
 *
 *  Created on: 2015年2月5日
 *      Author: feng
 */

#ifndef SRC_CHILD_H_
#define SRC_CHILD_H_

#include "HSListener.h"
#include <iostream>
using namespace std;
class child : public HSListener
{
public:
	virtual void onConnect();
	virtual void onDisConect();
	virtual void onMessage(int cmd,std::string msg);
	virtual void onReLogin();
	virtual void onLoginFalse();
	virtual void onLoginSuccess();
};



#endif /* SRC_CHILD_H_ */
