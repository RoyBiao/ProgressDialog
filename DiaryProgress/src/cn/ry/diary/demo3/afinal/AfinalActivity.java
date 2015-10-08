package cn.ry.diary.demo3.afinal;

import java.util.Date;
import java.util.List;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.annotation.view.ViewInject;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class AfinalActivity extends Activity {
	@ViewInject(id=R.id.textView) TextView textView; //这里使用了afinal的ioc功能，以后将会讲到
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_afinal);
		textView = (TextView) findViewById(R.id.textView);
	}

	public void afinalClick(View view) {
		switch (view.getId()) {
		case R.id.httpGet:
			httpGet();
			break;
		case R.id.httpSet:
			httpSet();
			break;
		case R.id.DBOperation:
			dbOperation();
			break;
		default:
			break;
		}
	}

	private void dbOperation() {
		FinalDb db = FinalDb.create(this);

		User user = new User();
		user.setEmail("afinal@tsz.net");
		user.setName("探索者");
		user.setRegisterDate(new Date());
		db.save(user);
		List<User> userList = db.findAll(User.class);// 查询所有的用户
		System.out.println("AfinalOrmDemoActivity"+
				"用户数量：" + (userList != null ? userList.size() : 0));

		textView.setText(userList.get(0).getName() + ":"
				+ user.getRegisterDate());
	}

	private void httpGet() {
		FinalHttp fh = new FinalHttp();
		fh.get("http://www.yangfuhai.com", new AjaxCallBack<Object>() {

			@Override
			public void onLoading(long count, long current) { // 每1秒钟自动被回调一次
				System.out.println(current + "/" + count);
			}

			@Override
			public void onSuccess(Object t) {
				System.out.println(t == null ? "null" : t);
			}

			@Override
			public void onStart() {
				// 开始http请求的时候回调
			}

			@Override
			public void onFailure(Throwable t, int errorNo, String strMsg) {
				// 加载失败的时候回调
				System.out.println("strMsg:" + strMsg);
			}
		});
	}

	private void httpSet() {
		AjaxParams params = new AjaxParams();
		params.put("from", "bdwz");

		FinalHttp fh = new FinalHttp();
		fh.post("http://china.huanqiu.com/article/2015-10/7708554.html",
				params, new AjaxCallBack<Object>() {
					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						System.out.println("strMsg:" + strMsg);
					}

					@Override
					public void onStart() {
						super.onStart();
					}

					@Override
					public void onLoading(long count, long current) {
						super.onLoading(count, current);
						System.out.println("count:" + count + ",,,current:"
								+ current);
					}

					@Override
					public void onSuccess(Object t) {
						super.onSuccess(t);
						System.out.println("Object:" + t);
					}
				});

	}
}
