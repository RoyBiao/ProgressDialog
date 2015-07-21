package com.design.observer2;

public class Test {

	public static void main(String[] args) {
		Subject seSubject=new Secrecory();
		StockObserver observer=new StockObserver("xiaoming", seSubject);
		seSubject.Attach(observer);
		((Secrecory)seSubject).setAction("老板拉了了");
		seSubject.Notify();
		
		Subject bossSubject=new Boss();
		StockObserver observerB=new StockObserver("xiaoming", bossSubject);
		bossSubject.Attach(observerB);
		((Boss)bossSubject).setAction("NTM");
		bossSubject.Notify();
	}

}
