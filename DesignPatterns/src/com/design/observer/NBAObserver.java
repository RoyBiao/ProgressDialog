package com.design.observer;

public class NBAObserver extends Observer {

	public NBAObserver(String name, Secretary secretary) {
		super(name, secretary);
	}

	@Override
	public void Update() {
		System.out.println(secretary.getAction()+","+name+"¹Ø±ÕNBA");
	}

}
