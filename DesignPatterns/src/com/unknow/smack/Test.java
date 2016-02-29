package com.unknow.smack;
import java.util.Scanner;

import org.jivesoftware.smack.AccountManager;
import org.jivesoftware.smack.Chat;
import org.jivesoftware.smack.ChatManager;
import org.jivesoftware.smack.Connection;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.MessageListener;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

public class Test {

	public final static String ip = "192.168.1.110";
	public final static int port = 5222;
	public final static String serverName = "ruibiao-lenovo-g580";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Scanner input = new Scanner(System.in);  
			String username = input.nextLine();
			String password = input.nextLine();
			String reasouce = input.nextLine();
			String toJID = input.nextLine()+"@ruibiao-lenovo-g580";
			receiveBroadcast(username,password,reasouce,toJID);
		} catch (XMPPException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 登录操作
	 */
	public static void login(String username,String password,String reasouce,String toJID) throws XMPPException {
		XMPPConnection.DEBUG_ENABLED = true;
		AccountManager accountManager;
		final ConnectionConfiguration connectionConfig = new ConnectionConfiguration(
				ip, port, serverName);

		// 允许自动连接
		connectionConfig.setReconnectionAllowed(true);
		connectionConfig.setSendPresence(true);

		Connection connection = new XMPPConnection(connectionConfig);
		try {
			connection.connect();// �?启连�?
			accountManager = connection.getAccountManager();// 获取账户管理�?
		} catch (XMPPException e) {
			throw new IllegalStateException(e);
		}

		// 登录
		connection.login(username, password, reasouce);
		System.out.println(connection.getUser());
		connection.getChatManager()
				.createChat(toJID, null)
				.sendMessage("Hello word!");
	}
	/**
	 * 聊天
	 */
	public static void receiveMsg(String username,String password,String reasouce,String toJID) throws XMPPException {
		XMPPConnection.DEBUG_ENABLED = true;  
		AccountManager accountManager;  
		final ConnectionConfiguration connectionConfig = new ConnectionConfiguration(  
		       ip, port, serverName);  
		  
		// 允许自动连接  
		connectionConfig.setReconnectionAllowed(true);  
		connectionConfig.setSendPresence(true);  
		  
		Connection connection = new XMPPConnection(connectionConfig);  
		try {  
		    connection.connect();// �?启连�?  
		    accountManager = connection.getAccountManager();// 获取账户管理�?  
		} catch (XMPPException e) {  
		    throw new IllegalStateException(e);  
		}  
		  
		// 登录  
		connection.login(username, password,reasouce);    
		ChatManager chatmanager = connection.getChatManager();  
		Chat newChat = chatmanager.createChat(toJID, new MessageListener() {  
		    public void processMessage(Chat chat, Message message) {  
		        if (message.getBody() != null) {  
		            System.out.println("Received from �?"  
		                    + message.getFrom() + "�? message: "  
		                    + message.getBody());  
		        }  
		  
		    }  
		});  
		Scanner input = new Scanner(System.in);  
		while (true) {  
		    String message = input.nextLine();   
		    newChat.sendMessage(message);  
		}
	}
	
	/**
	 * 广播
	 */
	public static void receiveBroadcast(String username,String password,String reasouce,String toJID) throws XMPPException {
		XMPPConnection.DEBUG_ENABLED = false;  
	    AccountManager accountManager;  
	    final ConnectionConfiguration connectionConfig = new ConnectionConfiguration(  
	            ip, port, serverName);  
	      
	    // 允许自动连接  
	    connectionConfig.setReconnectionAllowed(true);  
	    connectionConfig.setSendPresence(true);  
	      
	    Connection connection = new XMPPConnection(connectionConfig);  
	    try {  
	        connection.connect();// �?启连�?  
	        accountManager = connection.getAccountManager();// 获取账户管理�?  
	    } catch (XMPPException e) {  
	        throw new IllegalStateException(e);  
	    }  
	    connection.login(username, password,reasouce);   
	    Message newmsg = new Message();   
	    newmsg.setTo(toJID);  
	    newmsg.setSubject("重要通知");  
	    newmsg.setBody("今天下午2�?60分有会！");  
	    newmsg.setType(Message.Type.headline);// normal支持离线   
	    connection.sendPacket(newmsg);  
	    connection.disconnect();  
	}
}
