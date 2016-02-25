/*
 * RawData.h
 *
 *  Created on: 2015-1-30
 *  类功能：处理通信层原始数据类
 */
#ifndef RAWDATA_H_
#define RAWDATA_H_

#include "MacroDef.h"
#include "string.h"
#include <string>

using namespace std;

class RawData {
public:
	RawData();
	virtual ~RawData();
	unsigned int crc32(char * buf, unsigned int len);
	char* encode(unsigned int cmd,const char *body,unsigned int* len);
	int decode(char *packet,unsigned int &cmd,std::string &s);

public:
	char* bagBuff;			//组包缓冲区
private:
	unsigned int	mIncreaseID;																										//包头自增ID
	unsigned int	mBaseID;																												//包头baseID
};

#endif /* RAWDATA_H_ */
