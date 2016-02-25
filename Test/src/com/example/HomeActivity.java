package com.example;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;

import com.example.test.MainActivity;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// 网络状态
		ConnectivityManager connectMgr = (ConnectivityManager) this
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = connectMgr.getActiveNetworkInfo();
		if (info != null) {
			System.out.println("network type:" + info.getType());
			System.out.println("network type_name:" + info.getTypeName());
			System.out.println("network subtype:" + getNetworkClass(info.getSubtype()));
			System.out.println("network subtype_name:" + info.getSubtypeName());
			
			if(info.getTypeName().equals("wifi")){
				
			}
		}
	}

	public void test1(View view) {
		startActivity(new Intent(this, MainActivity.class));
	}

	public void test2(View view) {
		startActivity(new Intent(this, com.example.test2.MainActivity.class));
	}

	public static String getNetworkClass(int networkType) {
		switch (networkType) {
		case TelephonyManager.NETWORK_TYPE_GPRS:
		case TelephonyManager.NETWORK_TYPE_EDGE:
		case TelephonyManager.NETWORK_TYPE_CDMA:
		case TelephonyManager.NETWORK_TYPE_1xRTT:
		case TelephonyManager.NETWORK_TYPE_IDEN:
			return "2G";
		case TelephonyManager.NETWORK_TYPE_UMTS:
		case TelephonyManager.NETWORK_TYPE_EVDO_0:
		case TelephonyManager.NETWORK_TYPE_EVDO_A:
		case TelephonyManager.NETWORK_TYPE_HSDPA:
		case TelephonyManager.NETWORK_TYPE_HSUPA:
		case TelephonyManager.NETWORK_TYPE_HSPA:
		case TelephonyManager.NETWORK_TYPE_EVDO_B:
		case TelephonyManager.NETWORK_TYPE_EHRPD:
		case TelephonyManager.NETWORK_TYPE_HSPAP:
			return "3G";
		case TelephonyManager.NETWORK_TYPE_LTE:
			return "4G";
		default:
			return "";
		}
	}
}
