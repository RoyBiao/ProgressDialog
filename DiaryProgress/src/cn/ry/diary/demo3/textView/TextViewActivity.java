package cn.ry.diary.demo3.textView;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import cn.ry.diary.R;

public class TextViewActivity extends Activity {

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_textview);
//		final String value = "谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁是谁你谁你是谁你谁你是谁你谁你是谁你谁你是谁你谁v";
		final String value = "akjsdhfkhakfjkjasflawieulajsdlfjasdhljfasbbbajhflahflasjhflasdlfhasldhflwjeakjsdhfkhakfjkjasflawieulajsdlfjasdhljfasbbbajhflahflasjhflasdlfhasldhflwjeakjsdhfkhakfjkjasflawieulajsdlfjasdhljfasbbbajhflahflasjhflasdlfhasldhflwjeakjsdhfkhakfjkjasflawieulajsdlfjasdhljfasbbbajhflahflasjhflasdlfhasldhflwje";
		
		textView = (TextView) findViewById(R.id.textView);
		textView.setLines(3);
//		textView.setText(value);
		
		System.out.println("line getTextSize:"+textView.getTextSize());
		System.out.println("line getLineHeight:"+textView.getLineHeight());
		
		StringBuilder text = new StringBuilder();
		Rect bounds = new Rect(0, 0, textView.getMeasuredWidth(), textView.getMeasuredHeight());
		TextPaint paint;
		paint = textView.getPaint();
		paint.getTextBounds(value, 0, value.length(), bounds);
		
		float h = bounds.width() / textView.getMeasuredHeight();
		if(h > 3) {
		
			for(int i = 0; i < value.length(); i++) {
				paint.getTextBounds(text.toString() + value.charAt(i) + "...展开", 0, text.length(), bounds);
				float height = bounds.width() / textView.getWidth();
				if(height > 3) {
					break;
				}
				text.append(value.charAt(i));
			}
			textView.setText(text);
			
			String ttt = "展开";
			SpannableString spanttt = new SpannableString(ttt);
			ClickableSpan clickttt = new ClickableSpan() {
	
				@Override
				public void onClick(View widget) {
					textView.setLines(Integer.MAX_VALUE);
					textView.setText(value);
				}
			};
			spanttt.setSpan(clickttt, 0, ttt.length(),
					Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
			textView.append(spanttt);
		
		}
		
		textView.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
