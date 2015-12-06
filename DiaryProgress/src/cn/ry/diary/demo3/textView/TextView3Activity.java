package cn.ry.diary.demo3.textView;

import android.app.Activity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class TextView3Activity extends Activity {
	private TextView tv;
	private String str = "Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。";
	private int maxlength = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textview);
		tv = (TextView) findViewById(R.id.textView);
//		if (str.length() < maxlength) {
//			tv.setText(str);
//		} else {
//			changStatus();
//		}
		
		openText(tv, str);
		
	}

	private void changStatus() {
		tv.setText("");
		tv.setMaxLines(4);
		tv.setText(str.substring(0, 105));
		
		String ttt = "...展开";
		SpannableString span = new SpannableString(ttt);
		ClickableSpan rightClickableSpan = new ClickableSpan() {
			@Override
			public void onClick(View view) {
				tv.setMaxLines(Integer.MAX_VALUE);
				tv.setText(str);
			}
		};
		span.setSpan(rightClickableSpan, 0,
				ttt.length(),
				Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		tv.append(span);
		tv.setMovementMethod(LinkMovementMethod.getInstance());
	}
	
	public static void openText(final TextView textView, final String text) {
		if (TextUtils.isEmpty(text)) {
			return;
		}
		if (text.length() <= 100) {
			textView.append(text);
		} else {
			textView.setMaxLines(4);
			textView.append(text.substring(0, 100));

			String ttt = "...展开";
			SpannableString span = new SpannableString(ttt);
			ClickableSpan rightClickableSpan = new ClickableSpan() {
				@Override
				public void onClick(View view) {
					textView.setMaxLines(Integer.MAX_VALUE);
					textView.append(text.subSequence(100, text.length()));
				}
			};
			span.setSpan(rightClickableSpan, 0, ttt.length(),
					Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
			textView.append(span);
			textView.setMovementMethod(LinkMovementMethod.getInstance());
		}
	}
}
