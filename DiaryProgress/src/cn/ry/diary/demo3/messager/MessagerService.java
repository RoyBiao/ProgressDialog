package cn.ry.diary.demo3.messager;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

public class MessagerService extends Service {
	class handle extends Handler {
		@Override
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case 0:
				try {
					Bundle bundle = (Bundle) msg.obj;
					mMessenger = msg.replyTo;
					Message smsg = Message.obtain();
					smsg.what = 1;
					smsg.obj = bundle;
					mMessenger.send(smsg);
					System.out.println("MessagerService:"
							+ bundle.getString("CONTENT"));
					exec();
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				break;
			default:
				break;
			}
		}
	}

	private final Messenger cbMessenger = new Messenger(new handle());
	private Messenger mMessenger;

	@Override
	public IBinder onBind(Intent intent) {
		return cbMessenger.getBinder();
	}

	private int sum;

	public void exec() {
		sum = 0;
		for (int i = 0; i < 100000; i++){
			//System.out.println("Messager sum:"+sum);
			sum += 1;
		}
	}

}
