package cn.ry.diary.demo4.property.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.animation.Animator.AnimatorListener;
import com.nineoldandroids.animation.AnimatorInflater;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;
import com.nineoldandroids.animation.ValueAnimator.AnimatorUpdateListener;

public class PropertyAnimationActivity extends Activity {

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_property_animation);
		textView = (TextView) this.findViewById(R.id.textView);
	}

	public void propertyClick(View view) {
//		ValueAnimator 是ObjectAnimator的父类
//		ValueAnimator 操作于值
//		ObjectAnimator 操作于属性  
 		ObjectAnimator animator = null;
		switch (view.getId()) {
		case R.id.alphaBt:
			animator = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);
			animator.addUpdateListener(new AnimatorUpdateListener() {

				@Override
				public void onAnimationUpdate(ValueAnimator arg0) {
					System.out.println("ValueAnimator arg0:" + arg0);
				}
			});
			
			animator.addListener(new AnimatorListener() {
				@Override
				public void onAnimationStart(Animator arg0) {
				}
				
				@Override
				public void onAnimationRepeat(Animator arg0) {
				}
				
				@Override
				public void onAnimationEnd(Animator arg0) {
				}
				
				@Override
				public void onAnimationCancel(Animator arg0) {
				}
			});
			
			animator.setDuration(5000);
			animator.start();
			break;

		case R.id.rotationBt:
			animator = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);
			animator.setDuration(5000);
			animator.start();
			break;

		case R.id.translationXBt:
			float curTranslationX = (textView.getLeft() + textView.getRight()) / 2;
			animator = ObjectAnimator.ofFloat(textView, "translationX",
					curTranslationX, -500f, curTranslationX);
			animator.setDuration(5000);
			animator.start();
			break;

		case R.id.scaleYBt:
			animator = ObjectAnimator.ofFloat(textView, "scaleY", 1f, 3f, 1f);
			animator.setDuration(5000);
			animator.start();
			break;
			
		case R.id.animatorSetBt:
		    ObjectAnimator moveIn = ObjectAnimator.ofFloat(textView, "translationX", -500f, 0f);  
		    ObjectAnimator rotate = ObjectAnimator.ofFloat(textView, "rotation", 0f, 360f);  
		    ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(textView, "alpha", 1f, 0f, 1f);  
		    AnimatorSet animSet = new AnimatorSet();  
		    animSet.play(rotate).with(fadeInOut).after(moveIn);  
		    animSet.setDuration(5000);  
		    animSet.start();  
			break;
		case R.id.animatorSetFileBt:
			 Animator animator2 = AnimatorInflater.loadAnimator(PropertyAnimationActivity.this, R.animator.anim_file);  
			 animator2.setTarget(view);  
			 animator2.start(); 
			break;
		default:
			break;
		}
	}
}
