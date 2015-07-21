package com.design.observer2;

public interface Subject {
	
	String getAction();
	void Attach(Observer observer);
	void Detah(Observer observer);
	void Notify();
}
