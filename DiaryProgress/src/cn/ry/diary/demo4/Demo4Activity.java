package cn.ry.diary.demo4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.ry.diary.R;
import cn.ry.diary.demo4.menu.PathMenuActivity;
import cn.ry.diary.demo4.menu.YoukuMenuActivity;
import cn.ry.diary.demo4.rotate3d.Rotate3DActivity;
import cn.ry.diary.demo4.spinner.SpinnerActivity;
import cn.ry.diary.demo4.viewpager.ViewPagerActivity;

public class Demo4Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo4);
	}

	public void buttonClick(View view) {
		switch (view.getId()) {
		case R.id.bt_rotate3d:
			startActivity(new Intent(this, Rotate3DActivity.class));
			break;

		case R.id.bt_vp:
			startActivity(new Intent(this, ViewPagerActivity.class));
			break;

		case R.id.bt_sp:
			startActivity(new Intent(this, SpinnerActivity.class));
			break;

		case R.id.bt_youku:
			startActivity(new Intent(this, YoukuMenuActivity.class));
			break;

		case R.id.bt_path:
			startActivity(new Intent(this, PathMenuActivity.class));
			break;
		default:

			break;
		}
	}
}
