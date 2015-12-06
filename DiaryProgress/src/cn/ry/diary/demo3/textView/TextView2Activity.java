package cn.ry.diary.demo3.textView;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class TextView2Activity extends Activity {

	private TextView tv;

	private String status = "up";
	private String str = "Android是一种基于Linux的自由及开放源代码的操作系统，13824125203主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。Android是一种基于Linux的自由及开放源代码的操作系统，主要使用于移动设备，如智能手机和平板电脑，由Google公司和开放手机联盟领导及开发。";
	private String str_show = "";
	private int maxlength = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textview);
		tv = (TextView) findViewById(R.id.textView);
		if (str.length() < maxlength) {
			tv.setText(str);
		} else {
			changStatus();
		}
	}

	private void changStatus() {
		tv.setText("");
		Drawable drawable = null;
		if (status.equals("down")) {
			drawable = getResources().getDrawable(
					android.R.drawable.arrow_up_float);
			status = "up";
			str_show = str;
			tv.setMaxLines(10000);
		} else if (status.equals("up")) {
			drawable = getResources().getDrawable(
					android.R.drawable.arrow_down_float);
			status = "down";
			tv.setMaxLines(4);
			str_show = str.substring(0, maxlength);
			str_show += "...";
		}
		String spanString = str_show;
		spanString = spanString.substring(0, spanString.length());
		drawable.setBounds(0, 0, drawable.getIntrinsicWidth(),
				drawable.getIntrinsicHeight());
		SpannableString spannable = new SpannableString(spanString.toString()
				+ "s");
		ImageSpan span = new ImageSpan(drawable, ImageSpan.ALIGN_BASELINE);
		spannable.setSpan(span, spanString.toString().length(), spanString
				.toString().length() + "s".length(),
				Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		ClickableSpan rightClickableSpan = new ClickableSpan() {

			@Override
			public void onClick(View view) {
				changStatus();
			}
		};
		spannable.setSpan(rightClickableSpan, spanString.toString().length(),
				spanString.toString().length() + "s".length(),
				Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		tv.setText(spannable);
		tv.setMovementMethod(LinkMovementMethod.getInstance());

	}

}
