package com.unknow.synchronize2;

public class Info { // 定义信息类
	private String name = "李兴华"; // 定义name属性
	private String content = "JAVA讲师"; // 定义content属性
	private boolean flag = false; // 设置标志位

	public synchronized void set(String name, String content) {
		if (!flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.setName(name); // 设置名称
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.setContent(content); // 设置内容
		flag = false; // 改变标志位，表示可以取走
		super.notify();
	}

	public synchronized void get() {
		if (flag) {
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " --> " + this.getContent());
		flag = true; // 改变标志位，表示可以生产
		super.notify();
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return this.name;
	}

	public String getContent() {
		return this.content;
	}
}
