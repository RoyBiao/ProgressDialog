package cn.ry.diary.demo2.input;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import cn.ry.diary.R;

public class HidenInput extends Activity implements OnClickListener {

	private InputMethodManager inputMethodManager;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hiden_input);

		button = (Button) findViewById(R.id.hidenInputBt);
		button.setOnClickListener(this);
		inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		inputMethodManager.hideSoftInputFromWindow(getWindow().getCurrentFocus().getWindowToken(), 0);
		return super.onTouchEvent(event);
	}

	@Override
	public void onClick(View arg0) {
		
	}

}
