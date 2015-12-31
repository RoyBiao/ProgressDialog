package cn.ry.diary;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.ry.diary.demo.DemoActivity;
import cn.ry.diary.demo2.Demo2Activity;
import cn.ry.diary.demo3.Demo3Activity;
import cn.ry.diary.demo4.Demo4Activity;
import cn.ry.diary.demo5.Demo5Activity;

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
		case R.id.demo3:
			startActivity(new Intent(this, Demo3Activity.class));
			break;
		case R.id.demo4:
			startActivity(new Intent(this, Demo4Activity.class));
			break;
		case R.id.demo5:
			startActivity(new Intent(this, Demo5Activity.class));
			break;
		default:
			break;
			
		}
	}
}
