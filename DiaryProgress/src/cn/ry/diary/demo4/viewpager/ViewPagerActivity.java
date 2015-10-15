package cn.ry.diary.demo4.viewpager;

import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import cn.ry.diary.R;

public class ViewPagerActivity extends Activity {

	private ViewPager viewPager;
	private TextView title;
	private int[] imageIds;
	private ArrayList<ImageView> images;
	private String[] titles;
	private ArrayList<View> dots;
	private MyPagerAdapter adapter;
	
	private int oldPosition = 0;//上一次圆点的位置
	private ScheduledExecutorService scheduledExecutor;
	
	private int currentIndex = 0; //当前页面的位置

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_viewpager);
		
		initData();
		initView();
	}

	//准备初始化数据
	private void initData() {
		
		//图片
		imageIds = new int[]{
				R.drawable.a,
				R.drawable.b,
				R.drawable.c,
				R.drawable.d,
				R.drawable.e
		};
		//用来显示的图片
		images = new ArrayList<ImageView>();
		for (int i = 0; i < imageIds.length; i++) {
			
			ImageView imageView = new ImageView(getApplicationContext());
			imageView.setImageResource(imageIds[i]);
			imageView.setScaleType(ScaleType.FIT_XY);
			images.add(imageView);
		}
		
		//文字
		titles = new String[]{
				"巩俐不低俗，我就不能低俗",
				"扑树又回来啦！再唱经典老歌引万人大合唱",
				"揭秘北京电影如何升级",
				"乐视网TV版大派送",
				"热血屌丝的反杀"
		};
		
		//圆点
		dots = new ArrayList<View>();
		dots.add(findViewById(R.id.dot_0));
		dots.add(findViewById(R.id.dot_1));
		dots.add(findViewById(R.id.dot_2));
		dots.add(findViewById(R.id.dot_3));
		dots.add(findViewById(R.id.dot_4));
	}

	private void initView() {
		viewPager = (ViewPager) findViewById(R.id.viewPager);
		title = (TextView) findViewById(R.id.title);
		
		title.setText(titles[0]);
		
		adapter = new MyPagerAdapter();
		viewPager.setAdapter(adapter);
		
		viewPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}
	
	private class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int position) {

			//记录当前页面
			currentIndex = position;
			
			//文字更新
			title.setText(titles[position]);
			
			
			//圆点更新
			//更新当前页面为白色的圆点
			dots.get(position % images.size()).setBackgroundResource(R.drawable.dot_focused);
			//更新上一个页面为灰色的圆点
			dots.get(oldPosition % images.size()).setBackgroundResource(R.drawable.dot_normal);
			
			//更新上一个页面的位置
			oldPosition = position;
		}
		
	}
	
	private class MyPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			//return images.size();
			
			return Integer.MAX_VALUE;
			
		}

		//判断当前页面显示的数据 与 新页面的数据是否相同
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0 == arg1;
		}

		//初始化数据
		@Override
		public Object instantiateItem(ViewGroup viewPager, int position) {
			// TODO Auto-generated method stub
//			viewPager.addView(images.get(position));
			viewPager.addView(images.get(position));
			
			return images.get(position % images.size());
		}
		
		//销毁数据
		@Override
		public void destroyItem(ViewGroup viewPager, int position, Object object) {
			// TODO Auto-generated method stub
			//super.destroyItem(container, position, object);
			
			viewPager.removeView(images.get(position % images.size()));
		}
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		//启动切换图片
		
		scheduledExecutor = Executors.newSingleThreadScheduledExecutor();
		
		scheduledExecutor.scheduleAtFixedRate(new MyPagerTask(), 2, 2, TimeUnit.SECONDS);
		
	}
	
	//切换图片任务类
	private class MyPagerTask implements Runnable{

		@Override
		public void run() {
			//切换页面
//			currentIndex = (currentIndex + 1) % images.size();
			currentIndex++;
			
			
			//viewPager.setCurrentItem(item);//设置当前页面
			
			//更新UI  Handler
			handler.sendEmptyMessage(0);
			
		}
		
	}
	
	private Handler handler = new Handler(){

		@Override
		public void handleMessage(Message msg) {
			//super.handleMessage(msg);
			//切换viewPager当前页面
			viewPager.setCurrentItem(currentIndex);

		}
	};
	
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		
		//停止切换图片
		scheduledExecutor.shutdown();
	}

}
