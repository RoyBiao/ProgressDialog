package com.design.state;

public class NonnState extends State {

	@Override
	public void writeProgram(Work w) {
		if (w.getHour() < 13) {
			System.out.println("当前时间：" + w.getHour() + "点饿了，午饭：犯困，午休。");
		} else {
			w.setState(new AfternonnState());
			w.writeProgram();
		}
	}

}
