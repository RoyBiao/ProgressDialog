package cn.ry.diary.demo3.IBinder;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class MyActivity extends Activity {
	private IBinder ib = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ibinder);
		mTextView = (TextView) findViewById(R.id.text);
		bindService(new Intent("cn.ry.diary.demo3.IBinder.MyService"),
				mConnection, Context.BIND_AUTO_CREATE);

	}

	private ServiceConnection mConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			ib = service;
		}
	};
	private TextView mTextView;

	public void onItemClick(View v) {
		final Parcel pc = Parcel.obtain();
		final Parcel pc_reply = Parcel.obtain();
		switch (v.getId()) {
		case R.id.play:
			pc.writeString("playing");
			try {
				// 进行调用
				ib.transact(1, pc, pc_reply, 0);
				mTextView.setText(pc_reply.readString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case R.id.stop:
			pc.writeString("stoping");
			try {
				// 进行调用
				ib.transact(2, pc, pc_reply, 0);
				mTextView.setText(pc_reply.readString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case R.id.exit:
			if (mConnection != null) {
				unbindService(mConnection);
				mConnection = null;
			}
			break;

		case R.id.count1:
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						ib.transact(3, pc, pc_reply, 0);
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
						ib.transact(4, pc, pc_reply, 0);
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
						ib.transact(5, pc, pc_reply, 0);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
				}
			}).start();
			break;
		default:
			break;
		}
	}
}
