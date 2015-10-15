package cn.ry.diary.demo4.menu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.RotateAnimation;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import cn.ry.diary.R;

public class YoukuMenuActivity extends Activity implements OnClickListener{

	private ImageButton home;
	private ImageButton menu;
	private RelativeLayout level2;
	private RelativeLayout level3;
	private boolean isLevel2Show = true;
	private boolean isLevel3Show = true;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_youkumenu);
		
		initView();
	}

	private void initView() {
		
		level2 = (RelativeLayout) findViewById(R.id.level2);
		level3 = (RelativeLayout) findViewById(R.id.level3);
		
		home = (ImageButton) findViewById(R.id.home);
		menu = (ImageButton) findViewById(R.id.menu);
		
		home.setOnClickListener(this);
		menu.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.menu:
			//实现3级导航的显示、隐藏
			
			if(!isLevel3Show){
				//隐藏--> 显示
				MyAnimation.startAnimationIN(level3, 500);
			} else {
				// 显示 --> 隐藏
				MyAnimation.startAnimationOUT(level3, 500, 0);
			}
			
			//更新3级导航的显示状态
			isLevel3Show = !isLevel3Show;
			
			break;
		case R.id.home:
			
			if(!isLevel2Show){
				///隐藏--> 显示2级导航
				MyAnimation.startAnimationIN(level2, 500);
			} else {
				// 显示 --> 隐藏
				if(isLevel3Show){
					//隐藏 3级导航
					MyAnimation.startAnimationOUT(level3, 500, 0);
					//隐藏 2级导航
					MyAnimation.startAnimationOUT(level2, 500, 500);
					
					//更新3级导航的显示状态
					isLevel3Show = false;
				} else {
					//隐藏 2级导航
					MyAnimation.startAnimationOUT(level2, 500, 0);
				}
			}
			
			//更新2级导航的显示状态
			isLevel2Show = !isLevel2Show;
			
			break;

		}
		
		
	}
	public static class MyAnimation {

		//导航进入动画
		public static void startAnimationIN(ViewGroup viewGroup, int duration){
			
			for (int i = 0; i < viewGroup.getChildCount(); i++) {
				//为ImageButton设置基本操作
				viewGroup.getChildAt(i).setVisibility(View.VISIBLE);//显示 
				viewGroup.getChildAt(i).setClickable(true);//允许点击
				viewGroup.getChildAt(i).setFocusable(true);//允许获得焦点
			}
			
			Animation animation;
			/**
			 *	出去旋转角度  逆时针(负)   右--> 左    0 --> -180
			 *  进入旋转角度  顺时针(正)   左--> 右   -180 --> 0
			 * fromDegrees	旋转起始角度
			 * toDegrees	旋转结束角度
			 * pivotXType	x轴参照物
			 * pivotXValue	参照 x轴参照物的哪位位置进行旋转(0% ----100%   0.0f -- 1.0f)
			 * pivotYType   y轴参照物
			 * pivotYValue	参照 y轴参照物的哪位位置进行旋转(0% ----100%   0.0f -- 1.0f)
			 */
			animation = new RotateAnimation(-180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
			animation.setFillAfter(true);//将动画停留在动画运行结束的位置
			animation.setDuration(duration);//动画运行时间
			
			//将动画指定给对应的导航使用
			viewGroup.startAnimation(animation);
		}
		
		
		//导航出去动画
		public static void startAnimationOUT(final ViewGroup viewGroup, int duration, int startOffSet){
			
			Animation animation = new RotateAnimation(0, -180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 1.0f);
			animation.setFillAfter(true);//将动画停留在动画运行结束的位置
			animation.setDuration(duration);//动画运行时间
			animation.setStartOffset(startOffSet);//动画延迟启动时间
			animation.setAnimationListener(new AnimationListener() {
				
				@Override
				public void onAnimationStart(Animation arg0) {//启动
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationRepeat(Animation arg0) {//再次启动
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void onAnimationEnd(Animation arg0) {//结束
					for (int i = 0; i < viewGroup.getChildCount(); i++) {
						//为ImageButton设置基本操作
						viewGroup.getChildAt(i).setVisibility(View.GONE);//不显示
					}
				}
			});
			
			//将动画指定给对应的导航使用
			viewGroup.startAnimation(animation);
			
		}
			
	}

}
