package cn.ry.diary.demo.popupwindow;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow;

@SuppressLint("ViewConstructor")
public class YiPopupWindow extends PopupWindow {
	public YiPopupWindow(View contentView, int width, int height,
			boolean focusable) {
		super(contentView, width, height, focusable);
		init();
		initContentView(contentView);
	}

	public YiPopupWindow(View contentView, int width, int height) {
		super(contentView, width, height);
		init();
		initContentView(contentView);
	}

	public YiPopupWindow(View contentView) {
		super(contentView);
		init();
		initContentView(contentView);
	}

	@Override
	public void setContentView(View contentView) {
		// TODO Auto-generated method stub
		super.setContentView(contentView);
		initContentView(contentView);
	}

	protected void init() {
		// 设置了popWind.setOutsideTouchable(true)后，当调用popWind.showAsDropDown(v,xoff,yoff)时，
		// 其他控件都不能点击了，控件需要等popwind消失才能获取touch事件
		setOutsideTouchable(true);
		setTouchable(true);
		setFocusable(true);
	}

	protected void initContentView(View contentView) {
		if (contentView == null) {
			return;
		}
		contentView.setFocusable(true);
		contentView.setFocusableInTouchMode(true);
		contentView.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View arg0, int arg1, KeyEvent arg2) {
				if (arg1 == KeyEvent.KEYCODE_BACK) {
					if (isShowing()) {
						dismiss();
					}
				}
				return false;
			}
		});
		contentView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				if (isShowing()) {
					dismiss();
				}
				return false;
			}
		});
	}
}
