package com.design.state;

public class AfternonnState extends State {

	@Override
	public void writeProgram(Work w) {
		if (w.getHour() < 17) {
			System.out.println("当前时间：" + w.getHour() + "点下午状态还不错，继续努力。");
		} else {
			w.setState(new EveningState());
			w.writeProgram();
		}
	}

}
