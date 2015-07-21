package com.design.observer;

public abstract class Observer {
	protected String name;
	protected Secretary secretary;
	
	public Observer(String name,Secretary secretary){
		this.name=name;
		this.secretary=secretary;
	}
	public abstract void Update();
	
}
