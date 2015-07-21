package com.design.observer2;

public class NBAObserver extends Observer {

	
	public NBAObserver(String name, Subject subject) {
		super(name, subject);
	}

	@Override
	public void Update() {
		System.out.println(subject.getAction()+","+name+"¹Ø±ÕNBA");
	}
	

}
