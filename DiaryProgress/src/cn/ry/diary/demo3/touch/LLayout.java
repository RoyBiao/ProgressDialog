package cn.ry.diary.demo3.touch;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class LLayout extends FrameLayout {

	public LLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
	}

	public LLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public LLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	// ViewGroup
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		Log.i("LTAG", "LLayout onInterceptTouchEvent");
		Log.i("LTAG",
				"LLayout onInterceptTouchEvent default return"
						+ super.onInterceptTouchEvent(ev));
		return super.onInterceptTouchEvent(ev);
	}

	// View
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.i("LTAG", "LLayout onTouchEvent");
		Log.i("LTAG",
				"LLayout onTouchEvent default return"
						+ super.onTouchEvent(event));
		return super.onTouchEvent(event);
	}
}
