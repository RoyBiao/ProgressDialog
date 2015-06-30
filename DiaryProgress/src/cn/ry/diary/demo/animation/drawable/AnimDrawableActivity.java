package cn.ry.diary.demo.animation.drawable;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.ImageView;
import cn.ry.diary.R;

public class AnimDrawableActivity extends Activity {
	
	private AnimationDrawable loadingAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_anim_drawable);
		//将该逐帧xml文件设置为ImageView的背景
		ImageView loadingImg = (ImageView) findViewById(R.id.loading);
		loadingImg.setBackgroundResource(R.drawable.loading);
		loadingAnimation = (AnimationDrawable) loadingImg.getBackground();
		
		loadingAnimation.setEnterFadeDuration(2000);
		loadingAnimation.setExitFadeDuration(2000);
	}

	/**
	 * 触摸屏幕，结束动画
	 */
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			loadingAnimation.stop();
			return true;
		}
		return super.onTouchEvent(event);
	}

	/**
	 * activity显示到屏幕则开启动画
	 */
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		super.onWindowFocusChanged(hasFocus);
		if (hasFocus)
			loadingAnimation.start();
	}

}
