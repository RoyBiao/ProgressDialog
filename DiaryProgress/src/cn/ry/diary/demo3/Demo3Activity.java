package cn.ry.diary.demo3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.ry.diary.R;
import cn.ry.diary.demo3.IBinder.MyActivity;
import cn.ry.diary.demo3.cusorloader.CusorLoaderActivity;
import cn.ry.diary.demo3.messager.MessagerActivity;

public class Demo3Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo3);
	}

	public void onClickItem(View view) {
		switch (view.getId()) {
		case R.id.IBinderService:
			startActivity(new Intent(this, MyActivity.class));
			break;
		case R.id.MessengerService:
			startActivity(new Intent(this, MessagerActivity.class));
			break;
		case R.id.cusorLoader:
			startActivity(new Intent(this, CusorLoaderActivity.class));
			break;
		default:
			break;
		}
	}
}
