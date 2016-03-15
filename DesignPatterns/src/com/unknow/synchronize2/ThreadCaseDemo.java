package com.unknow.synchronize2;

public class ThreadCaseDemo {
	public static void main(String args[]) {
		Info info = new Info(); // 实例化Info对象
		Producer pro = new Producer(info); // 生产者
		Consumer con = new Consumer(info); // 消费者
		new Thread(pro).start();
		new Thread(con).start();
	}
}
