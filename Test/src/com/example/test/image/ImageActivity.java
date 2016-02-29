package com.example.test.image;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.R;
import com.ikantech.support.cache.YiStoreCache;

public class ImageActivity extends Activity{
	
	private final static String IMAGE_URL =YiStoreCache.convertToFileName("http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918f36e29dc5523d269759eec48a.jpg");
	private ImageView imageView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_image);
		imageView = (ImageView) this.findViewById(R.id.imageView);
	}
	
	public void getLoacalBitmap(View view){
		Bitmap bitmap=ImageUtil.getLoacalBitmap(IMAGE_URL);
		imageView.setImageBitmap(bitmap);
	}
	
	
}
