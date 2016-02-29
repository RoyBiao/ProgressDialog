//: concurrency/MainThread.java
package com.thinking.concurrent.demo01;

public class MainThread {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
			LiftOff launch = new LiftOff();
			new Thread(launch).start();
		}
		System.out.println("wait for liftOff");
	}
} 
/*
 * Output: #0(9), #0(8), #0(7), #0(6), #0(5), #0(4), #0(3), #0(2), #0(1),
 * #0(Liftoff!),
 */// :~
