package cn.ry.diary.demo3.afinal;

import java.io.File;
import java.util.Date;
import java.util.List;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalHttp;
import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;
import net.tsz.afinal.http.HttpHandler;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class AfinalActivity extends Activity {
	TextView textView;
	@SuppressWarnings("rawtypes")
	private HttpHandler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_afinal);
		textView = (TextView) findViewById(R.id.textView);
	}

	public void afinalClick(View view) {
		switch (view.getId()) {
		case R.id.DBOperation:
			dbOperation();
			break;
		case R.id.httpGet:
			httpGet();
			break;
		case R.id.httpGetWithParam:
			httpGetWithParam();
			break;
		case R.id.httpGetSync:
			httpGetSync();
			break;
		case R.id.httpPost:
			httpPost();
			break;
		case R.id.httpPostWithParam:
			httpPostWithParam();
			break;
		case R.id.httpDownLoad:
			httpDownLoad();
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
		System.out.println("AfinalOrmDemoActivity" + "用户数量："
				+ (userList != null ? userList.size() : 0));

		textView.setText(userList.get(0).getName() + ":"
				+ user.getRegisterDate());
	}

	private void httpGet() {
		FinalHttp fh = new FinalHttp();
		fh.get("http://blog.csdn.net/baggio785/article/details/661412",
				new AjaxCallBack<Object>() {

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
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						// 加载失败的时候回调
						System.out.println("strMsg:" + strMsg);
					}
				});
	}

	// http://114.67.57.69:5280/api/zq_userinfo?uid=1006797&myuid=1000000
	private void httpGetWithParam() {
		AjaxParams params = new AjaxParams();
		// params.put("url",
		// "-s6JgP4a1flOTtCVY5_h2C-5ffIE93VuGjBNprw_HHf9T0z6fKMULNxPc8ioNRSD4Q_hgZYqXvfD2hdeBO4f9_");
		params.put("uid", "1000304");
		params.put("myuid", "1000016");
		FinalHttp fh = new FinalHttp();
		fh.get("http://114.67.57.69:5280/api/zq_userinfo", params,
		// fh.get("http://baike.baidu.com/link",
				new AjaxCallBack<Object>() {
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

	private void httpGetSync() {
		FinalHttp fh = new FinalHttp();
		Object t = fh
				.getSync("http://blog.csdn.net/baggio785/article/details/661412");
		System.out.println("Object:" + t);
	}

	private void httpPost() {
		FinalHttp fh = new FinalHttp();
		fh.post("http://blog.csdn.net/baggio785/article/details/661412",
				new AjaxCallBack<Object>() {
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
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						// 加载失败的时候回调
						System.out.println("strMsg:" + strMsg);
					}
				});
	}

	private void httpPostWithParam() {
		AjaxParams params = new AjaxParams();
		params.put(
				"url",
				"-s6JgP4a1flOTtCVY5_h2C-5ffIE93VuGjBNprw_HHf9T0z6fKMULNxPc8ioNRSD4Q_hgZYqXvfD2hdeBO4f9_");
		FinalHttp fh = new FinalHttp();
		fh.post("http://baike.baidu.com/link", params,
		// AjaxParams params = new AjaxParams();
		// params.put("uid", "1000304");
		// params.put("myuid", "1000016");
		// FinalHttp fh = new FinalHttp();
		// fh.post("http://114.67.57.69:5280/api/zq_userinfo", params,
				new AjaxCallBack<Object>() {
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
		
//		Executor executor =YiThreadFactory.getExecutorService();
//		executor.execute(new Runnable() {
//			@Override
//			public void run() {
//				YiHttpRequest request = new YiHttpRequest(
//						"http://114.67.57.69:5280/api/zq_userinfo", YiHttpRequestMode.MODE_POST);
//				request.addParam("uid", "1000304");
//				request.addParam("myuid", "1000016");
//				YiHttpResponse response = InHttpHelper.execute(request);
//				if (response.getErrorCode() == YiHttpResponse.SUCCESS) {
//					System.out.println("YiHttpResponse"+response.getResponse());
//					System.out.println("YiHttpResponse"+response.getUrl());
//					for(Header str:response.getHeaders()){
//						System.out.println("header:"+str);
//					}
//				}
//			}
//		});
	}

	private void httpDownLoad() {
		FinalHttp fh = new FinalHttp();
		// 调用download方法开始下载

		handler = fh.download("http://www.hslive.cn/download/ZQ.apk", // 这里是下载的路径
				// true:断点续传 false:不断点续传（全新下载）
				"/mnt/sdcard/ZQ1.apk", true,// 这是保存到本地的路径
				new AjaxCallBack<File>() {
					@Override
					public void onFailure(Throwable t, int errorNo,
							String strMsg) {
						super.onFailure(t, errorNo, strMsg);
						System.out.println("strMsg:" + strMsg);
						// 调用stop()方法停止下载
						handler.stop();
					}

					@Override
					public void onStart() {
						super.onStart();
					}

					@Override
					public void onLoading(long count, long current) {
						super.onLoading(count, current);
						System.out.println("下载进度：" + current + "/" + count);
						textView.setText("下载进度：" + current / count);
					}

					@Override
					public void onSuccess(File t) {
						super.onSuccess(t);
						System.out.println(t == null ? "null" : t
								.getAbsoluteFile().toString());
						textView.setText(t == null ? "null" : t
								.getAbsoluteFile().toString());
						// 调用stop()方法停止下载
						handler.stop();
					}
				});

	}
}
