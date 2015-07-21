package com.design.state;

public class ForenoonState extends State{

	@Override
	public void writeProgram(Work w) {
		if (w.getHour() < 12) {
			System.out.println("��ǰʱ�䣺" + w.getHour() + "�����繤��������ٱ���");
		} else {
			w.setState(new NonnState());
			w.writeProgram();
		}
	}

}
