/*
 * RawData.h
 *
 *  Created on: 2015-1-30
 *  类功能：处理通信层原始数据类
 */

#include "RawData.h"

RawData::RawData() {
	bagBuff = new char[NET_PACKET_BODY_MAX];
	mIncreaseID=1;
}

RawData::~RawData() {
	delete bagBuff;
	bagBuff = NULL;
}

/*
 * 计算crc32值
 * @param buf 字符串指针
 * @param len 字符串长度
 * @return 返回计算出来到crc32的值
 * */
unsigned int RawData::crc32(char * buf, unsigned int len)
{
    unsigned int crc = 0xffffffff;
	unsigned char * p = (unsigned char *)buf;
	unsigned int i = 0;
    for (; i < len; i++)
    {
	    crc = ((crc >> 8) ^ table[(crc ^ p[i]) & 0xff]);
	}
	crc = crc ^ 0xffffffff;
	return crc;
}

/*
 * 打包数据
 *@param cmd 消息类型
 *@param body 消息内容到指针
 *@param m_nextId nextid
 *@param m_uniqueBaseId baseid
 *@return 返回打包好到字符串指针
 * */
char* RawData::encode(unsigned int cmd,const char *body,unsigned int* len)
{
	mBaseID= (unsigned int)(((unsigned long long)time(0) & 0xFFFF) << 16) | (((unsigned long long) & mIncreaseID) & 0xFFFF);
	unsigned int packetsize=strlen(body)+NET_PACKET_SIZE;
	*len=packetsize;
	unsigned int crc=0;
	PacketHead head;//设置包头

	/*赋值给包头*/
	memcpy(&head.tag,NET_PACKET_TAG_CONTENT,NET_PACKET_TAG_MAX);
	memcpy(&head.size,&packetsize,NET_PACKET_SIZE_MAX);
	memcpy(&head.cmd,&cmd,NET_PACKET_CMD_MAX);
	memcpy(&head.uniqueId,&mBaseID,NET_PACKET_UID_MAX);
	memcpy(&head.increaseId,&mIncreaseID,NET_PACKET_INCREASEID_MAX);
	memcpy(&head.property,"000",NET_PACKET_PROPERTY_MAX);
	memcpy(&head.reserved,"00",NET_PACKET_RESERVE_MAX);

	/*开始组装消息包*/
	memset(bagBuff, 0, MAXSIZE);
	memcpy(bagBuff,&head,(NET_PACKET_SIZE-NET_PACKET_CRC_MAX));
	memcpy(bagBuff+(NET_PACKET_SIZE-NET_PACKET_CRC_MAX),body,strlen(body));
	crc=crc32(bagBuff,((NET_PACKET_SIZE-NET_PACKET_CRC_MAX)+strlen(body)));
	memcpy(bagBuff+((NET_PACKET_SIZE-NET_PACKET_CRC_MAX)+strlen(body)),&crc,NET_PACKET_CRC_MAX);
	mIncreaseID++;
	return bagBuff;
}

/*
 * 解包数据
 *@param packet 要解包的字符串的指针
 *@param cmd 解包出来的数据类型
 *@param s 解包出来的内容
 *@return 0 解包成功
 *@return -1 无效包
 *@return -2 crc检验失败
 * */
int RawData::decode(char *packet,unsigned int &cmd,std::string &s)
{
	unsigned int packetsize,crc,i;
	char *body=NULL;
	PacketHead head;

	if(packet==NULL)
	return -1;

	//检测包的有效性，以有没有HSI开头为准
	char *p=packet;
	for(i=0;i<1000;i++)
	{
		if((*p=='H')&&(*(p+1)=='S')&&(*(p+2)=='I'))
			break;
		p++;
	}
	if((*p=='H')&&(*(p+1)=='S')&&(*(p+2)=='I'));
	else
	{
		return -1;
	}

	//取出包的大小
	packetsize=*((unsigned int*)(p+NET_PACKET_TAG_MAX));

	//校验CRC
	crc=*((unsigned int*)(p+packetsize-NET_PACKET_CRC_MAX));
	if(crc!=crc32(p,packetsize-NET_PACKET_CRC_MAX))
	{
		return -2;
	}

	//取出其他值
	memcpy(&head,p,NET_PACKET_HEADER_MAX);
	memcpy(&cmd,&(head.cmd),NET_PACKET_CMD_MAX);

	p += NET_PACKET_HEADER_MAX;

	for(i=0;i<packetsize-NET_PACKET_SIZE;i++)
	{
		s+=*p;
		p++;
	}
	//成功，返回0
	return 0;
}
