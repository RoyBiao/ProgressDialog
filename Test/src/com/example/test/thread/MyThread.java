package com.example.test.thread;

import android.util.Log;

public class MyThread {

	// 由JNI中的线程回调
	private static void fromJNI(int i) {
		Log.v("Java------>", "" + i);
	}

	// 本地方法
	public native void mainThread();

	public native void setJNIEnv();

	static {
		// 加载动态库
		System.loadLibrary("JNIThreads");
	}
}
