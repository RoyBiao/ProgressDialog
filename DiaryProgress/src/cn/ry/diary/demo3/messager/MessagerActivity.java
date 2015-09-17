package cn.ry.diary.demo3.messager;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import cn.ry.diary.R;

public class MessagerActivity extends Activity {
	private Messenger mMessenger;
	
	private Handler mHandler=new Handler(){
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 1:
				Bundle bundle = (Bundle) msg.obj;
				System.out.println("MessagerAcivity:"
						+ bundle.getString("CONTENT"));
				break;

			default:
				break;
			}
		};
	};
	
	private Messenger cbMessenger=new Messenger(mHandler);
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_messager);

		bindService(new Intent("cn.ry.diary.demo3.messager.MessagerService"),
				mConnection, Context.BIND_AUTO_CREATE);
	}

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mMessenger = new Messenger(service);
		}
	};

	public void onItemClick(View v) {
		switch (v.getId()) {
		case R.id.count1:
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Message msg = Message.obtain();
						msg.what=0;
						Bundle bundle=new Bundle();
						bundle.putString("CONTENT", "My name is Messenger Activity");
						msg.obj=bundle;
						msg.replyTo = cbMessenger;
						mMessenger.send(msg);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}).start();
			break;
		case R.id.count2:
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Message msg = Message.obtain();
						msg.what=0;
						Bundle bundle=new Bundle();
						bundle.putString("CONTENT", "My name is Messenger Activity");
						msg.obj=bundle;
						mMessenger.send(msg);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}).start();
			break;
		case R.id.count3:
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Message msg = Message.obtain();
						msg.what=0;
						Bundle bundle=new Bundle();
						bundle.putString("CONTENT", "My name is Messenger Activity");
						msg.obj=bundle;
						mMessenger.send(msg);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}).start();
			break;
		case R.id.exit:
			if (mConnection != null) {
				unbindService(mConnection);
				mConnection = null;
			}
			break;
		default:
			break;
		}
	}
}
