package cn.ry.diary.demo.popupwindow;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import cn.ry.diary.R;

public class PopupWindowActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popup_window);
	}
	
	public void popupWindowOnClik(View view){
		View v=View.inflate(this, R.layout.activity_drawble,null);
//		PopupWindow popupWindow=new PopupWindow(LayoutParams.MATCH_PARENT, 200);
//		popupWindow.setContentView(v);
//		popupWindow.setOutsideTouchable(true);
//		popupWindow.setFocusable(true);
//		popupWindow.setTouchable(true);
//		popupWindow.showAsDropDown(view);
		
		YiPopupWindow yiPopupWindow=new YiPopupWindow(v, LayoutParams.MATCH_PARENT, 200);
		yiPopupWindow.showAsDropDown(view);
	}
}
