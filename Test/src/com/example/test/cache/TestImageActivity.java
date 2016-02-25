package com.example.test.cache;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.R;
import com.ikantech.support.listener.YiImageLoaderListener;

public class TestImageActivity extends Activity{

	private ImageView imageView;
	private final static String IMAGE_URL="http://g.hiphotos.baidu.com/image/pic/item/622762d0f703918f36e29dc5523d269759eec48a.jpg";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_testimage);
		imageView = (ImageView) this.findViewById(R.id.image);
	}
	
	public void showImageFromUrl( View view){
		YiAsyncImageLoader.loadBitmapFromUrl(IMAGE_URL, new YiImageLoaderListener() {
			
			@Override
			public void onImageLoaded(String url, Bitmap bitmap) {
				imageView.setImageBitmap(bitmap);
			}
		});
		
	}
	
	public void showImageFromCache(View view){
		YiAsyncImageLoader.loadBitmapFromStore(IMAGE_URL, new YiImageLoaderListener() {
			@Override
			public void onImageLoaded(String url, Bitmap bitmap) {
				if(bitmap!=null){
					imageView.setImageBitmap(bitmap);
				}
			}
		});
	}
	
	public void loadBitmapFromeStoreSync(View view){
		Bitmap bitmap=YiAsyncImageLoader.loadBitmapFromeStoreSync(IMAGE_URL);
		imageView.setImageBitmap(bitmap);
	}
	
	public void removeMemoryCache(View view){
		YiAsyncImageLoader.removeMemoryCache(IMAGE_URL);
	}
}
