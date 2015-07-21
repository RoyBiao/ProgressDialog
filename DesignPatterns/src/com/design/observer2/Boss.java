package com.design.observer2;

import java.util.ArrayList;
import java.util.List;

public class Boss implements Subject{
	private List<Observer> observers=new ArrayList<Observer>();
	private String action;
	@Override
	public String getAction() {
		return action;
	}

	@Override
	public void Attach(Observer observer) {
		observers.add(observer);
	}

	@Override
	public void Detah(Observer observer) {
		observers.remove(observer);
	}

	@Override
	public void Notify() {
		for(Observer observer : observers){
			observer.Update();
		}
	}

	public void setAction(String action) {
		this.action = action;
	}

	
}
