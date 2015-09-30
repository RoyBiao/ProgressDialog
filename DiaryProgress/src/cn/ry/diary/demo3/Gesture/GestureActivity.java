package cn.ry.diary.demo3.Gesture;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import cn.ry.diary.R;

public class GestureActivity extends Activity {

	private MyButton myButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gesture);

		myButton = (MyButton) findViewById(R.id.button_doubleTap);
		myButton.setOnDoubleClickListener(new MyButton.OnDoubleClickListener() {
			@Override
			public void onDoubleClick(View view) {
				Log.d("", "点击两次");
			}
		});
	}
}
