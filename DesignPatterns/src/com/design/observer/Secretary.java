package com.design.observer;

import java.util.ArrayList;
import java.util.List;

public class Secretary  {

	private List<Observer> observers=new ArrayList<Observer>();
	
	private String action;

	public void Attach(Observer observer) {
		observers.add(observer);
	}

	public void Detah(Observer observer) {
		observers.remove(observer);
	}

	public void Notify() {
		for(Observer observer : observers){
			observer.Update();
		}
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
	
	
	
}
