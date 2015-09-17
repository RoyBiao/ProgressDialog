package cn.ry.diary.demo3.IBinder;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import cn.ry.diary.R;

public class MyService extends Service {
	private IBinder mBinder = null;
	private MediaPlayer mPlayer = null;
	private Handler mHandler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			if(msg.what==3||msg.what==4||msg.what==5){
				exec();
			}
		};
	};
	@Override
	public IBinder onBind(Intent intent) {
		
		
		return mBinder = new MyBinder(getApplicationContext(), this);
	}

	public void play() {
		if (mPlayer != null)
			return;
		mPlayer = MediaPlayer.create(MyService.this, R.raw.office);
		try {
			mPlayer.start();
		} catch (Exception e) {
		}
	}

	public void stop() {
		if (mPlayer != null) {
			mPlayer.stop();
			mPlayer.release();
			mPlayer = null;
		}
	}

	public class MyBinder extends Binder {
		private Context ctx;
		private MyService srv;

		public MyBinder(Context cx, MyService service) {
			ctx = cx;
			srv = service;
		}

		@Override
		protected boolean onTransact(int code, Parcel data, Parcel reply,
				int flags) throws RemoteException {
			switch (code) {
			case 1:
				reply.writeString("music is starting");
				System.out.println("MyService onTransact:" + data.readString());
				srv.play();
				break;

			case 2:
				reply.writeString("music is stopting");
				System.out.println("MyService onTransact:" + data.readString());
				srv.stop();
				break;
			case 3:
				mHandler.sendEmptyMessage(3);
				break;
			case 4:
				mHandler.sendEmptyMessage(4);
				break;
			case 5:
				mHandler.sendEmptyMessage(5);
				break;
			default:
				break;
			}
			return true;
		}
	}

	private int sum;

	public synchronized void exec() {
		sum = 0;
		for (int i = 0; i < 100000; i++){
			System.out.println("sum:"+sum);
			sum += 1;
		}
		// 異步或同步回傳 sum值
	}

}
