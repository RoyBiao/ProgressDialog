package cn.ry.diary.demo.flashview;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import cn.ry.diary.R;

import com.gc.flashview.FlashView;
import com.gc.flashview.constants.EffectConstants;
import com.gc.flashview.listener.FlashViewListener;

public class FlashViewActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flashview);

		FlashView flashView = (FlashView) findViewById(R.id.flash_view);
		List<String> imageUrls = new ArrayList<String>();
		imageUrls.add("http://www.qipaox.com/tupian/200810/20081051924582.jpg");
		imageUrls
				.add("http://www.bz55.com/uploads1/allimg/120312/1_120312100435_8.jpg");
		imageUrls
				.add("http://img3.iqilu.com/data/attachment/forum/201308/21/192654ai88zf6zaa60zddo.jpg");
		imageUrls
				.add("http://img2.pconline.com.cn/pconline/0706/19/1038447_34.jpg");
		imageUrls
				.add("http://www.kole8.com/desktop/desk_file-11/2/2/2012/11/2012113013552959.jpg");
		imageUrls.add("http://www.237.cc/uploads/pcline/712_0_1680x1050.jpg");
		flashView.setImageUris(imageUrls);
		flashView.setEffect(EffectConstants.CUBE_EFFECT);// 更改图片切换的动画效果

		flashView.setOnPageClickListener(new FlashViewListener() {
			@Override
			public void onClick(int position) {
				Toast.makeText(getApplicationContext(),
						"你的点击的是第" + (position + 1) + "张图片！", 1000).show();
			}
		});

	}

}
