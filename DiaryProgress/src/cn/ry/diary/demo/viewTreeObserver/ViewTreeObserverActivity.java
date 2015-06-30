package cn.ry.diary.demo.viewTreeObserver;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.Button;
import cn.ry.diary.R;

public class ViewTreeObserverActivity extends Activity {
	private boolean hasMeasured = false;
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewtree);
		
		button = (Button) this.findViewById(R.id.button);
		int height = button.getMeasuredHeight();
		int width = button.getMeasuredWidth();
		System.out.println("onCreate height:" + height);
		System.out.println("onCreate width:" + width);
		
		ViewTreeObserver vto = button.getViewTreeObserver();
		vto.addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
			public boolean onPreDraw() {
				if (hasMeasured == false) {
					int height = button.getMeasuredHeight();
					int width = button.getMeasuredWidth();
					// 获取到宽度和高度后，可用于计算
					System.out.println("Observer height:" + height);
					System.out.println("Observer width:" + width);
					hasMeasured = true;
				}
				return true;
			}
		});
	}
}
