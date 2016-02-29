package com.design.observer;

public class StockObserver extends Observer {

	public StockObserver(String name, Secretary secretary) {
		super(name, secretary);
	}

	@Override
	public void Update() {
		System.out.println(secretary.getAction()+","+name+"¹Ø±Õ¹ÉÆ±");
	}

}
