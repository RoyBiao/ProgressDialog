package com.design.state;

public class Work {

	private State current;

	private double hour;

	private boolean taskFinished;
	
	public Work(){
		current=new ForenoonState();
	}
	
	public void setState(State s){
		current=s;
	}
	
	public void writeProgram(){
		current.writeProgram(this);
	}
	
	
	
	
	public boolean isTaskFinished() {
		return taskFinished;
	}

	public void setTaskFinished(boolean taskFinished) {
		this.taskFinished = taskFinished;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

}
