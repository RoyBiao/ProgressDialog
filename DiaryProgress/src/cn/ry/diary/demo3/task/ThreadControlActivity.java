package cn.ry.diary.demo3.task;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import cn.ry.diary.R;
import cn.ry.diary.common.task.AbTaskItem;
import cn.ry.diary.common.task.AbTaskListener;
import cn.ry.diary.common.task.AbTaskObjectListener;
import cn.ry.diary.common.task.AbTaskQueue;

/**
 * 异步的使用参照 http://www.amsoft.cn/post-133.html
 * 
 * @author 还如一梦中
 * 
 */
public class ThreadControlActivity extends Activity implements OnClickListener{

	private TextView textView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thread_main);

		Button threadBtn = (Button) this.findViewById(R.id.threadBtn);
		Button queueBtn = (Button) this.findViewById(R.id.queueBtn);
		Button poolBtn = (Button) this.findViewById(R.id.poolBtn);
		Button taskBtn1 = (Button) this.findViewById(R.id.taskBtn1);
		Button taskBtn2 = (Button) this.findViewById(R.id.taskBtn2);
		threadBtn.setOnClickListener(this);
		queueBtn.setOnClickListener(this);
		poolBtn.setOnClickListener(this);
		taskBtn1.setOnClickListener(this);
		taskBtn2.setOnClickListener(this);
		
		textView = (TextView) this.findViewById(R.id.textView);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.threadBtn:
//			cn.ry.diary.common.task2.AbTaskPool.getInstance().executeQueue(new Runnable() {
//				
//				@Override
//				public void run() {
//					for(int i=0;i<100;i++){
//						System.out.println("Queue:"+Thread.currentThread().getName()+"__"+i);
//					}
//					
//				}
//			});
			AbTaskQueue queue1 =new AbTaskQueue();
			AbTaskItem item1=new AbTaskItem(new AbTaskListener(){
				@Override
				public void get() {
					for(int i=0;i<10000;i++){
						System.out.println("Queue:"+Thread.currentThread().getName()+"__"+i);
					}
				}
			});
			
			queue1.execute(item1);
			break;
		case R.id.queueBtn:
			System.out.println("ddeddedede0");
			AbTaskQueue queue =new AbTaskQueue();
			AbTaskItem item=new AbTaskItem(new AbTaskObjectListener() {
				
				@Override
				public <T> void update(T obj) {
					textView.setText(obj.toString());
				}
				
				@Override
				public <T> T getObject() {
					System.out.println("ddeddedede1");
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return (T) "HAHAHAHA";
				}
			});
			
			queue.execute(item);
			break;

		default:
			break;
		}
	}
}
