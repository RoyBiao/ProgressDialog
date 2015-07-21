package com.design.state;

public class EveningState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.isTaskFinished()){
			w.setState(new RestState());
			w.writeProgram();
		}else{
			if(w.getHour()<21){
				System.out.println("��ǰʱ�䣺"+w.getHour()+"��Ӱ�Ŷ��ƣ��֮����");
			}else{
				w.setState(new SleepingState());
				w.writeProgram();
			}
		}
	}

}
