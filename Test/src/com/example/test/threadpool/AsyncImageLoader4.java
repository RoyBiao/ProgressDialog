package com.example.test.threadpool;

import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import android.graphics.drawable.Drawable;
import android.os.Handler;

public class AsyncImageLoader4 {

	// 为了加快速度，在内存中开启缓存（主要应用于重复图片较多时，或者同一个图片要多次被访问，比如在ListView时来回滚动）
	public Map<String, SoftReference<Drawable>> imageCache = new HashMap<String, SoftReference<Drawable>>();
	
	// 固定五个线程来执行任务
	private ExecutorService executorService = Executors.newFixedThreadPool(5); 

	private final Handler handler = new Handler();
	
	public Drawable loadDrawable(final String imageUrl, final ImageCallback callback) {
		// 如果缓存过就从缓存中取出数据
		if (imageCache.containsKey(imageUrl)) {
			 SoftReference<Drawable> softReference = imageCache.get(imageUrl);
			 if (softReference.get() != null) {
				 return softReference.get();
			 }
		}
		
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				 final Drawable drawable = loadImageFromUrl(imageUrl);
				 imageCache.put(imageUrl, new SoftReference<Drawable>(drawable));
				 handler.post(new Runnable() {
                          public void run() {
                                  callback.imageLoaded(drawable);
                          }
                  });
			}
			
		});
		return null;
		
	}

	 // 从网络上取数据方法
     protected Drawable loadImageFromUrl(String imageUrl) {
         try {
             // 测试时，模拟网络延时，实际时这行代码不能有
                         //SystemClock.sleep(2000);
  
                         return Drawable.createFromStream(new URL(imageUrl).openStream(),
                                         "image.png");
  
                 } catch (Exception e) {
                         throw new RuntimeException(e);
             }
     }
	 // 对外界开放的回调接口
     public interface ImageCallback {
         // 注意 此方法是用来设置目标对象的图像资源
         public void imageLoaded(Drawable imageDrawable);
     }
}
