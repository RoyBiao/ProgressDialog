package com.design.state;

public class RestState extends State{

	@Override
	public void writeProgram(Work w) {
		System.out.println("��ǰʱ�䣺"+w.getHour()+"���°�ؼ��ˡ�");
	}

}
