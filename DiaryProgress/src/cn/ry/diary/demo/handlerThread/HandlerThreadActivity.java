package cn.ry.diary.demo.handlerThread;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class HandlerThreadActivity extends Activity {

	/**
	 * 
	 * 程序说明：
	 * 	UI Thread 通过handler向其他线程发送数据并进行打印
	 * 
	 */
	
	private Handler superHandler;
	private Handler normalHandler;
	private TextView mMainShowTextview;
	
	@SuppressLint("HandlerLeak")
	private Handler handler =new Handler(){
		public void handleMessage(Message msg) {
			if(msg.what==3){
				mMainShowTextview.setText(Thread.currentThread().getName());
			}
		};
	};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handler_thread);
		
		mMainShowTextview = (TextView) this.findViewById(R.id.main_show_textview);
		
		NormalThread normalThread = new NormalThread();
		normalThread.start();
		
		HandlerThread handlerThread = new HandlerThread("leochin.com");
		handlerThread.start();
		
		/*
		 * 将handlerThread中创建的looper传递给Handler。
		 * 
		 * 也就意味着该Handler收到Message后，程序在HandlerThread创建的线程中运行
		 * 
		 */
		superHandler = new Handler(handlerThread.getLooper()){

			@Override
			public void handleMessage(Message msg) {
				// TODO Auto-generated method stub
				super.handleMessage(msg);
				
				int what = msg.what;
				
				if(what == 2){
					handler.sendEmptyMessage(3);
					Log.d("wenhao",Thread.currentThread().getName()+" HandlerThread is OK");
				}
			}		
		};	
	}
	
	/**
	 * 
	 * 普通线程
	 * 
	 */
	class NormalThread extends Thread{

		@Override
		public void run() {
			
			Looper.prepare();
			
			normalHandler = new Handler(){

				@Override
				public void handleMessage(Message msg) {
					// TODO Auto-generated method stub
					super.handleMessage(msg);
					
					int what = msg.what;
					
					if(what == 1){
						Log.d("wenhao",Thread.currentThread().getName()+ " NormalThread is OK");
						handler.sendEmptyMessage(3);
					}
				}
				
				
			};
		
			Looper.loop();
		}
		
	}

	
	/**
	 * 
	 * 向普通线程发送数据
	 * 
	 * @param view
	 */
	public void normalThreadUse(View view){
		
		if(normalHandler == null){
			return;
		}
		
		normalHandler.sendEmptyMessage(1);
	}
	
	/**
	 * 
	 * 向HandlerThread发送数据
	 * 
	 * @param view
	 */
	public void handlerThreadUse(View view){
		
		if(superHandler == null){
			return;
		}
		
		superHandler.sendEmptyMessage(2);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
