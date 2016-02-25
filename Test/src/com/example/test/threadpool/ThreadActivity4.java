package com.example.test.threadpool;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import com.example.R;
import com.example.test.threadpool.AsyncImageLoader4.ImageCallback;

public class ThreadActivity4 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_threadpool);
	     loadImage3("http://www.baidu.com/img/baidu_logo.gif", R.id.imageView1);
	     loadImage3("http://www.chinatelecom.com.cn/images/logo_new.gif",
	                     R.id.imageView2);
	     loadImage3("http://cache.soso.com/30d/img/web/logo.gif",
	                     R.id.imageView3);
	     loadImage3("http://csdnimg.cn/www/images/csdnindex_logo.gif",
	                     R.id.imageView4);
	     loadImage3("http://images.cnblogs.com/logo_small.gif",
	                     R.id.imageView5);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	private AsyncImageLoader4 asyncImageLoader4 = new AsyncImageLoader4();
	
	private void loadImage3(final String url, final int id) {
         // 如果缓存过就会从缓存中取出图像，ImageCallback接口中方法也不会被执行
         Drawable cacheImage = asyncImageLoader4.loadDrawable(url,new ImageCallback() {
			
			@Override
			public void imageLoaded(Drawable imageDrawable) {
				((ImageView) findViewById(id)).setImageDrawable(imageDrawable);
			}
		});
         if (cacheImage != null) {
        	 ((ImageView) findViewById(id)).setImageDrawable(cacheImage);
         }
	}

}
