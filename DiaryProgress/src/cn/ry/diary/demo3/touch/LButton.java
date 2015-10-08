package cn.ry.diary.demo3.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Button;

public class LButton extends Button {

	public LButton(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	public LButton(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public LButton(Context context) {
		super(context);
	}

	// TextView <-- View
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i("LTAG", "onTouchEvent");
		Log.i("LTAG", "onTouchEvent default return" + super.onTouchEvent(event));
		return super.onTouchEvent(event);
	}
}