package com.design.state;

public class NonnState extends State {

	@Override
	public void writeProgram(Work w) {
		if (w.getHour() < 13) {
			System.out.println("��ǰʱ�䣺" + w.getHour() + "����ˣ��緹�����������ݡ�");
		} else {
			w.setState(new AfternonnState());
			w.writeProgram();
		}
	}

}
