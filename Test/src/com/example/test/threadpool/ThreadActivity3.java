package com.example.test.threadpool;

import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Menu;
import android.widget.ImageView;

import com.example.R;

public class ThreadActivity3 extends Activity {

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
	
	private Handler handler = new Handler();
	
	private ExecutorService executorService = Executors.newFixedThreadPool(5);
     // 引入线程池来管理多线程
     private void loadImage3(final String url, final int id) {
         executorService.submit(new Runnable() {
             public void run() {
                 try {
                         final Drawable drawable = Drawable.createFromStream(
                                         new URL(url).openStream(), "image.png");
                         // 模拟网络延时
                         SystemClock.sleep(2000);
                         handler.post(new Runnable() {
                                 public void run() {
                                         ((ImageView) ThreadActivity3.this.findViewById(id))
                                                         .setImageDrawable(drawable);
                                 }
                         });
                 } catch (Exception e) {
                         throw new RuntimeException(e);
                 }
             }
         });
     }

}
