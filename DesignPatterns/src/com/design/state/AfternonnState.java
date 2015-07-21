package com.design.state;

public class AfternonnState extends State {

	@Override
	public void writeProgram(Work w) {
		if (w.getHour() < 17) {
			System.out.println("��ǰʱ�䣺" + w.getHour() + "������״̬����������Ŭ����");
		} else {
			w.setState(new EveningState());
			w.writeProgram();
		}
	}

}
