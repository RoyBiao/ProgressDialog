package com.unknow.interfaces;

public class Caller {
	private MyCallInterface mc;

	public Caller() {
	}

	public void setI(MyCallInterface mc) {

		this.mc = mc;

	}

	// Caller�ĵ��÷���
	public void call() {
		mc.fuc();
	}
}
