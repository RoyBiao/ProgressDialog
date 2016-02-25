package com.example.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;

import com.example.R;
import com.example.test.AsyncTask.TestAsyncTaskActivity;
import com.example.test.cache.TestImageActivity;
import com.example.test.dialog.HsDialog;
import com.example.test.enum1.EnumActivity;
import com.example.test.image.ImageActivity;
import com.example.test.image.ImageActivity2;
import com.example.test.sharePreferance.HsUserInfo;
import com.example.test.sharePreferance.UserInfoActivity;
import com.example.test.task.TestTaskActivity;
import com.example.test.thread.ThreadActivity;
import com.example.test.viewpager.IndexActivity;
import com.ikantech.support.util.YiFileUtils;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	private Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			int i=msg.arg1;
			if(i==4){
				HsDialog.ShowDialog(MainActivity.this, "连接失败");
			}else{
				HsDialog.setMsgProgressDialog("test"+i);
			}
			
//			if(i==4){
//				HsDialog.dismiss();
//			}
		};
	};

	public void onclikButton(View view){
		HsDialog.showProgressDialog(this, "text");
		//HsDialog.dismiss();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i=0;
				for(;i<5;i++){
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Message msg=Message.obtain();
					msg.arg1=i;
					handler.sendMessage(msg);
				}				
			}
		}).start();
		
	}

	public void onclikButton2(View view){
//		HsDialog.ShowDialog(this, "title", "hello everyone", "cancel", "ok", 
//		new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				HsDialog.dismiss();
//			}
//		}, new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				HsDialog.dismiss();
//			}
//		});
		
//		HsDialog.ShowDialog(this, "Are you ready?");
		
		HsDialog.ShowDialog(this, "titile","ssssssss", "确定", new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HsDialog.dismiss();
			}
		});
	}

	public void onclikButton3(View view){
		startActivity(new Intent(MainActivity.this, ThreadActivity.class));
	}
	
	public void testHsUserInfo(View view){
		HsUserInfo info=HsUserInfo.getUserInfo(this, "username");
		info.setmUserName("username");
		info.setmPassword("123456");
		info.setmIsFirstLogin(true);
		info.setmEnableRememberPassword(true);
		info.setmEnableAutoLogin(true);
		info.persist(this);
		info.active(this);
		startActivity(new Intent(this, UserInfoActivity.class));
		
//		YiUserInfo info=YiUserInfo.getUserInfo(this, "username");
//		info.setUserName("username");
//		info.setPasswd("123456");
//		info.persist(this);
//		info.active(this);
//		startActivity(new Intent(this, UserInfoActivity.class));
	}
	
	public void testImageCache(View view){
		startActivity(new Intent(this, TestImageActivity.class));
		System.out.println(YiFileUtils.getStorePath());
	}
	
	public void imageOperation(View view){
		startActivity(new Intent(this, ImageActivity.class));
	}
	public void imageOperationLearning(View view){
		startActivity(new Intent(this, ImageActivity2.class));
	}
	
	public void ViewPagerFragment(View view){
		startActivity(new Intent(this, IndexActivity.class));
	}
	
	public void EnumTest(View view){
		startActivity(new Intent(this, EnumActivity.class));
	}
	
	public void ThreadPool(View view){
		startActivity(new Intent(this, com.example.test.threadpool.MainActivity.class));
	}
	
	public void cacheAllType(View view){
		startActivity(new Intent(this,com.example.test.cache2.ui.MainActivity.class));
	}
	
	public void testTask(View view){
		startActivity(new Intent(this,TestTaskActivity.class));
	}
	
	public void testAsyncTask(View view){
		startActivity(new Intent(this, TestAsyncTaskActivity.class));
	}
}
