/*
 * NetWork.h
 *
 *  Created on: 2015-1-30
 *  类功能：暴露给业务层使用的接口
 */
#ifndef HSAPI_H_
#define HSAPI_H_

#include "MacroDef.h"
#include "NetWork.h"
#include "RawData.h"
#include "HSListener.h"
#include "string"

using namespace std;

class HSAPI{
public:
	HSAPI();
	virtual ~HSAPI();

	/*
	 * 连接服务器
	 *@param ip 服务器ip
	 *@param port 服务器端口
	 *@return 0 连接成功
	 *@return -1 连接失败
	 * */
	int connect(std::string ip,unsigned short int port);

	/*
	 * 断开连接
	 * 无参数无返回
	 * */
	void disconnect();

	/*
	 * 设置监听
	 * 参数
	 * -监听类指针
	 * 无返回
	 * */
	void setListener(HSListener *listener);
	/*
	 * 注册账户
	 * @param username 用户名
	 * @param password 密码
	 * @param nickname 昵称
	 * @return 0 发送成功
	 * @return -1发送失败
	 * */
	int registerAccount(std::string username,std::string password,std::string nickname);

	/*
	* 登录
	* @param username 账户名
	* @param password 密码
	* @return 0 发送成功
	* @ return -1 发送失败
    * */
	int login(std::string username,std::string password);

	/*
	* 发送消息
	* @param msg 账户名
	* @param toname 接收用户
	* @return 0 发送成功
	* @ return -1 发送失败
    * */
	int chat(std::string msg,std::string toname);

	/*
	* 请求好友
	* @param id 用户id
	* @param ersion 好友版本
	* @return 0 发送成功
	* @return -1 发送失败
    * */
	int requestFriendsList(std::string id,std::string version);

	/*
	 * 发起好友申请
	 * @param username 用户名
	 * @param reason：备注
	 * @return 0 发送成功
	 * @return -1 发送失败
	 * */
	int applyFriend(std::string username,std::string reason);

	/*
	 * 同意好友申请
	 * @param username：发起申请到用户名
	 * @return 0 发送成功
	 * @return -1发送失败
	 * */
	int allow(std::string username);

	/*
	 * 拒绝好友申请
	 * @param username：发起申请的用户名
	 * @param reason：理由
	 * @return 0 发送成功
	 * @return -1发送失败
	 * */
	int refuse(std::string username,std::string reason);

	/*
	 * 移除好友
	 * @param username 要移除的用户名
	 * @return 0 发送成功
	 * @return -1 发送失败
	 * */
	int removeFriend(std::string username);

	/*
	 * 添加备注
	 * @param username 用户名
	 * @param memo 备注
	 * @return 0 发送成功
	 * @return -1发送失败
	 * */
	int addMemo(std::string username,std::string memo);

	/*
	 *修改分组
	 *@param username 用户名
	 *@param group 分组名
	 *@return 0 发送成功
	 *@return -1发送失败
	 * */
	int updataGroup(std::string username,std::string group);

	/*
	 * 修改用户资料
	 *@param nickname 昵称
	 *@param headportrait 头像
	 *@param signature 个性签名
	 *@param age 年龄
	 *@param  gender 性别（0男，1女）
	 *@return 0 发送成功
	 *@return -1发送失败
	 * */
	int updataInfo(std::string nickname,std::string headportrait,std::string signature,std::string age,std::string gender);

	/*
	 * 更改密码
	 *@param PWD 新密码
	 *@return 0 发送成功
	 *@return -1 发送失败
	 * */
	int changePWD(std::string PWD);

	/*
	 * 请求用户信息
	 * @param username 用户名
	 *  @return 0 发送成功
	 *  @return -1发送失败
	 * */
	int getUserInfo(std::string username);

private:
	NetWork *m_NetWork;
};

#endif /* HSAPI_H_ */
