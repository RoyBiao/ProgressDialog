package cn.ry.diary.demo.AnimationController;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import cn.ry.diary.R;

public class AnimationControllerActivity extends Activity{

	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_animation_controller);
		imageView = (ImageView) this.findViewById(R.id.imageView);
	}
	
	public void fadeIn(View view){
		AnimationController.fadeIn(imageView, 1000, 200);
	}
	
	public void fadeOut(View view){
		AnimationController.fadeOut(imageView, 1000, 200);
	}
	
	public void slideIn(View view){
		AnimationController.slideIn(imageView, 1000, 200);
	}
	
	public void scaleOut(View view){
		AnimationController.scaleOut(imageView, 1000, 200);
	}
	
	public void rotateIn(View view){
		AnimationController.rotateIn(imageView, 1000, 200);
	}
	
	public void rotateOut(View view){
		AnimationController.rotateOut(imageView, 1000, 200);
	}
	
	public void scaleRotateIn(View view){
		AnimationController.scaleRotateIn(imageView, 1000, 200);
	}
	
	public void scaleRotateOut(View view){
		AnimationController.scaleRotateOut(imageView, 1000, 200);
	}
	
	public void slideFadeIn(View view){
		AnimationController.slideFadeIn(imageView, 1000, 200);
	}
	
	public void slideFadeOut(View view){
		AnimationController.slideFadeOut(imageView, 1000, 200);
	}
}
