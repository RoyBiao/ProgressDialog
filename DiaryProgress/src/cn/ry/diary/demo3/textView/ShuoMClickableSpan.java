package cn.ry.diary.demo3.textView;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Toast;

public class ShuoMClickableSpan extends ClickableSpan{
	String string;
    Context context;
    public ShuoMClickableSpan(String str,Context context){
        super();
        this.string = str;
        this.context = context;
    }
     
     
    @Override
    public void updateDrawState(TextPaint ds) {
        ds.setColor(Color.BLUE);
    }
 
 
    @Override
    public void onClick(View widget) {
    	Toast.makeText(context, "onclick", 1).show();
    }
}
