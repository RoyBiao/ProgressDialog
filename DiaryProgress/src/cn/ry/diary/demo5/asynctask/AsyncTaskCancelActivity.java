package cn.ry.diary.demo5.asynctask;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.ry.diary.R;

public class AsyncTaskCancelActivity extends Activity {
	private final static String STATE_COMPUTE = "outState";
	private final static String TAG = "AsyncTaskCancelActivity";
	private LoginTask mTask;
	private TextView textview;
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask_cancel);

		Log.i(TAG, "this :" + AsyncTaskCancelActivity.this.toString());
		Log.i(TAG, "onCreate called in thread :"
				+ Thread.currentThread().getId());
		textview = (TextView) this.findViewById(R.id.textview);
		button = (Button) this.findViewById(R.id.button);
		button.setOnClickListener(new OnClickListener() {
			public void onClick(View viewParam) {
				mTask = new LoginTask();
				mTask.execute(10001);
			}
		});

		if (savedInstanceState != null
				&& savedInstanceState.containsKey(STATE_COMPUTE)) {
			int value= savedInstanceState.getInt(STATE_COMPUTE);
			mTask = new LoginTask();
			mTask.execute(value);
		}

	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.i(TAG,"onstop");
		if (mTask != null) {
			mTask.cancel(true);
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i(TAG,"onSaveInstanceState");
		if (mTask != null) {
			outState.putInt(STATE_COMPUTE, 10002);
		}
	}

	class LoginTask extends AsyncTask<Integer, Void, Integer> {

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			button.setEnabled(false);
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
			button.setEnabled(true);
			mTask = null;
		}

		@Override
		protected Integer doInBackground(Integer... params) {
			Integer lon = params[0];
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return lon;
		}

		@Override
		protected void onPostExecute(Integer result) {
			textview.setText("text:" + result);
			button.setEnabled(true);
		}
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			if (mTask != null
					&& mTask.getStatus() != AsyncTask.Status.FINISHED)
				mTask.cancel(true);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
}
