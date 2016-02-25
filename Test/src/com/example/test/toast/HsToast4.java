package com.example.test.toast;

import android.app.Application;
import android.widget.Toast;

public class HsToast4 extends Application {
	
	private static HsToast4 instance;
	//private static HsToast4 mContext = HsToast4.getInstance();

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
	}

	public static HsToast4 getInstance() {
		return instance;
	}


	public static void show(String msg) {
		Toast.makeText(instance, msg, Toast.LENGTH_SHORT).show();
	}

	public static void showL(String msg) {
		Toast.makeText(instance, msg, Toast.LENGTH_LONG).show();
	}

	public static void show(int msg) {
		Toast.makeText(instance, msg, Toast.LENGTH_SHORT).show();
	}

	public static void showL(int msg) {
		Toast.makeText(instance, msg, Toast.LENGTH_LONG).show();
	}
}
