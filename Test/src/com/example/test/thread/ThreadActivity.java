package com.example.test.thread;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.R;

public class ThreadActivity extends Activity{

	private MyThread mMyThread;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thread);
		mMyThread = new MyThread();
		//初始化JNI环境
		mMyThread.setJNIEnv();
	}
	
	public void onclikButton(View view){
		 //调用JNI中的函数来启动JNI中的线程
		mMyThread.mainThread();
	}
	
}

