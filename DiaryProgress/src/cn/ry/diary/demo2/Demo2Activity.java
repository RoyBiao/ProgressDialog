package cn.ry.diary.demo2;

<<<<<<< HEAD
import cn.ry.diary.R;
import cn.ry.diary.demo2.common.adapter.CommonAdapterActivity;
import cn.ry.diary.demo2.guideview.GuideViewActivity;
import cn.ry.diary.demo2.inflater.LayoutInflaterActivity;
import cn.ry.diary.demo2.webview.js.WebViewJSActivity;
=======
>>>>>>> 831a945419f70fc29a9972f189ea910ece7f0493
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import cn.ry.diary.R;
import cn.ry.diary.demo2.common.adapter.CommonAdapterActivity;
import cn.ry.diary.demo2.guideview.GuideViewActivity;
import cn.ry.diary.demo2.guideview2.GuideView2Activity;
import cn.ry.diary.demo2.inflater.LayoutInflaterActivity;

public class Demo2Activity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo2);
	}
	
	public  void onClickItem(View view) {
		switch (view.getId()) {
		case R.id.commonAdapterBt:
			startActivity(new Intent(this, CommonAdapterActivity.class));
			break;
		case R.id.LayoutInflaterBt:
			startActivity(new Intent(this, LayoutInflaterActivity.class));
			break;
		case R.id.guideViewBt:
			startActivity(new Intent(this, GuideViewActivity.class));
		case R.id.guideView2Bt:
			startActivity(new Intent(this, GuideView2Activity.class));
			break;
		case R.id.WebViewJsBt:
			startActivity(new Intent(this, WebViewJSActivity.class));
			break;
		default:
			break;
		}
	}
}
