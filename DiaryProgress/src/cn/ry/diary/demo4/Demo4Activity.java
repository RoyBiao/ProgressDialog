package cn.ry.diary.demo4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.ry.diary.R;
import cn.ry.diary.demo4.menu.PathMenuActivity;
import cn.ry.diary.demo4.menu.YoukuMenuActivity;
import cn.ry.diary.demo4.property.animation.PropertyAnimationActivity;
import cn.ry.diary.demo4.property.animation2.PropertyAnimation2Activity;
import cn.ry.diary.demo4.property.animation3.PropertyAnimation3Activity;
import cn.ry.diary.demo4.rotate3d.Rotate3DActivity;
import cn.ry.diary.demo4.spinner.SpinnerActivity;
import cn.ry.diary.demo4.viewpager.ViewPagerActivity;
import cn.ry.diary.demo4.webview.WebViewActivity;

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

		case R.id.bt_property_animation:
			startActivity(new Intent(this, PropertyAnimationActivity.class));
			break;
			
		case R.id.bt_property_animation2:
			startActivity(new Intent(this, PropertyAnimation2Activity.class));
			break;
			
		case R.id.bt_property_animation3:
			startActivity(new Intent(this, PropertyAnimation3Activity.class));
			break;
		case R.id.webview:
			startActivity(new Intent(this, WebViewActivity.class));
			break;
		default: 

			break;
		}
	}
}
