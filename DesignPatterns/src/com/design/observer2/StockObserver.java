package com.design.observer2;

public class StockObserver extends Observer {


	public StockObserver(String name, Subject subject) {
		super(name, subject);
	}

	@Override
	public void Update() {
		System.out.println(subject.getAction()+","+name+"¹Ø±Õ¹ÉÆ±");
	}

}
