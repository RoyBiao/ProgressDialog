package cn.ry.essence.demo01;

import cn.ry.essence.R;
import cn.ry.essence.demo01.swipeRefresh.MainActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Demo01Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo01);
	}

	public void demo01OnClick(View view) {
		switch (view.getId()) {
		case R.id.AIDLServiceBt:

			break;

		case R.id.SwipeRefresh:
			startActivity(new Intent(this, MainActivity.class));
			break;

		default:
			break;
		}
	}
}
