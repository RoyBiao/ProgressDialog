package cn.ry.diary.demo;

import java.util.Iterator;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import cn.ry.diary.R;
import cn.ry.diary.demo.AnimationController.AnimationControllerActivity;
import cn.ry.diary.demo.ShapeTextView.ShapeTextViewActivity;
import cn.ry.diary.demo.animation.drawable.AnimDrawableActivity;
import cn.ry.diary.demo.animation.view.AnimViewActivity;
import cn.ry.diary.demo.custom.drawable.MainActivity;
import cn.ry.diary.demo.drawable.DrawableActivity;
import cn.ry.diary.demo.flashview.FlashViewActivity;
import cn.ry.diary.demo.handlerThread.HandlerThreadActivity;
import cn.ry.diary.demo.popupwindow.PopupWindowActivity;
import cn.ry.diary.demo.screenfix.ScreenFixActivity;
import cn.ry.diary.demo.viewTreeObserver.ViewTreeObserverActivity;

public class DemoActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo);
		getSign(this);
	}


	public void ViewTreeObserver(View view){
		startActivity(new Intent(DemoActivity.this, ViewTreeObserverActivity.class));
	}
	public void AnimationController(View view){
		startActivity(new Intent(DemoActivity.this, AnimationControllerActivity.class));
	}
	
	public void drawable(View view){
		startActivity(new Intent(DemoActivity.this, DrawableActivity.class));
	}
	public void HandlerThread(View view){
		startActivity(new Intent(DemoActivity.this, HandlerThreadActivity.class));
	}
	public void ScreenFix(View view){
		startActivity(new Intent(DemoActivity.this, ScreenFixActivity.class));
	}
	
	public void PopupWindowOnClick(View view){
		startActivity(new Intent(DemoActivity.this, PopupWindowActivity.class));
	}
	
	public void FlashView(View view){
		startActivity(new Intent(DemoActivity.this, FlashViewActivity.class));
	}
	
	
	public void shapeTextView(View view){
		startActivity(new Intent(DemoActivity.this, ShapeTextViewActivity.class));
	}

	public void customDrawable(View view){
		startActivity(new Intent(DemoActivity.this, MainActivity.class));
	}
	
	public void AnimationDrawable(View view){
		startActivity(new Intent(DemoActivity.this, AnimDrawableActivity.class));
	}
	
	public void AnimationView(View view){
		startActivity(new Intent(DemoActivity.this, AnimViewActivity.class));
	}
	
	private void getSign(Context context) {
		PackageManager pm = getPackageManager();
		List<PackageInfo>  packinfos = pm.getInstalledPackages(PackageManager.GET_SIGNATURES);
		for(PackageInfo info : packinfos){
			if(info.packageName.equals("com.xisue.zhoumo")){
				System.out.println("zhoumo signatures:"+info.signatures[0].toCharsString());
				System.out.println("zhoumo applicationInfo:"+info.applicationInfo.loadLabel(pm).toString());
			}
		}
	}
	
	
		
}
