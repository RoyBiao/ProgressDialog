package com.design.state;

public class EveningState extends State{

	@Override
	public void writeProgram(Work w) {
		if(w.isTaskFinished()){
			w.setState(new RestState());
			w.writeProgram();
		}else{
			if(w.getHour()<21){
				System.out.println("当前时间："+w.getHour()+"点加班哦，疲累之极。");
			}else{
				w.setState(new SleepingState());
				w.writeProgram();
			}
		}
	}

}
