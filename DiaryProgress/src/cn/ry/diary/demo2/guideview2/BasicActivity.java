package cn.ry.diary.demo2.guideview2;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import cn.ry.diary.R;

public class BasicActivity extends Activity {
	private int guideResourceId = 0;// 引导页图片资源id

	@Override
	protected void onStart() {
		super.onStart();
		addGuideImage();// 添加引导页
	}

	/**
	 * 添加引导图片
	 */
	public void addGuideImage() {
        View view = getWindow().getDecorView().findViewById(R.id.my_content_view);//查找通过setContentView上的根布局
        if(view==null)return;
//        if(MyPreferences.activityIsGuided(this, this.getClass().getName())){
//            //引导过了
//            return;
//        }
        ViewParent viewParent = view.getParent();
        if(viewParent instanceof FrameLayout){
            final FrameLayout frameLayout = (FrameLayout)viewParent;
            if(guideResourceId!=0){//设置了引导图片
                final ImageView guideImage = new ImageView(this);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
                guideImage.setLayoutParams(params);
                guideImage.setScaleType(ScaleType.FIT_XY);
                guideImage.setImageResource(guideResourceId);
                guideImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        frameLayout.removeView(guideImage);
                        MyPreferences.setIsGuided(getApplicationContext(), BasicActivity.this.getClass().getName());//设为已引导
                    }
                });
                frameLayout.addView(guideImage);//添加引导图片
                
            }
        }
    }

	/**
	 * 子类在onCreate中调用，设置引导图片的资源id 并在布局xml的根元素上设置android:id="@id/my_content_view"
	 * 
	 * @param resId
	 */
	protected void setGuideResId(int resId) {
		this.guideResourceId = resId;
	}
}
