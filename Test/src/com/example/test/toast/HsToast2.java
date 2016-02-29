package com.example.test.toast;

import android.content.Context;
import android.widget.Toast;

public class HsToast2 {
	
	private static  Toast mToast;

	public synchronized static void showToat(Context context ,String text){
		if(mToast==null){
			mToast=Toast.makeText(context, text, Toast.LENGTH_SHORT);
			mToast.show();
		}else{
			mToast.setText(text);
			mToast.show();
		}
	}
}
