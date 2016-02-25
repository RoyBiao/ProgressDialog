package com.example.test.thread2;

import android.os.HandlerThread;

public class MyThread {
	public void a(){
		HandlerThread handlerThread=new HandlerThread("");
		handlerThread.start();
		handlerThread.getLooper();
		handlerThread.quit();
	}
}
