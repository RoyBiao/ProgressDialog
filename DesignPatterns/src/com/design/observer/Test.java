package com.design.observer;

public class Test {

	public static void main(String[] args) {
		Secretary secretary=new Secretary();
		StockObserver observer=new StockObserver("xiaoming", secretary);
		NBAObserver nbaObserver=new NBAObserver("xiaoniu", secretary);
		secretary.setAction("老板回来了");
		secretary.Attach(nbaObserver);
		secretary.Attach(observer);
		secretary.Notify();
	}
}
