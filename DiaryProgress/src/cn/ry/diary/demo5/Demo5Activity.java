package cn.ry.diary.demo5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.ry.diary.R;
import cn.ry.diary.demo5.asynctask.AsyncTaskCancelActivity;
import cn.ry.diary.demo5.asynctask2.AsyncTaskDemoActivity;
import cn.ry.diary.demo5.listviewrefresh.ListviewreFreshActivity;

public class Demo5Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo5);
	}

	public void buttonClick(View view) {
		switch (view.getId()) {
		case R.id.AsyncTaskCancel:
			startActivity(new Intent(this, AsyncTaskCancelActivity.class));
			break;
			
		case R.id.AsyncTask:
			startActivity(new Intent(this, AsyncTaskDemoActivity.class));
			break;
			
		case R.id.ListViewReFresh:
			startActivity(new Intent(this, ListviewreFreshActivity.class));
			break;

		}
	}
}
