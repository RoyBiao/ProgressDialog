package cn.ry.diary;

import java.security.Permission;

import cn.ry.diary.demo.DemoActivity;
import cn.ry.diary.demo2.Demo2Activity;
import cn.ry.diary.demo2.common.adapter.CommonAdapterActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PermissionInfo;
import android.os.Bundle;
import android.view.View;

public class IndexActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);
	}

	public void onCLickDemoItem(View view) {
		switch (view.getId()) {
		case R.id.demo1:
			startActivity(new Intent(this, DemoActivity.class));
			break;
		case R.id.demo2:
			startActivity(new Intent(this, Demo2Activity.class));
			break;
		default:
			break;
			
		}
	}
}
