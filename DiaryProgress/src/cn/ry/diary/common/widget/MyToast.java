package cn.ry.diary.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public enum MyToast {
	builder;
    private View v;
    private Toast it;
    	
    @SuppressLint("ShowToast")
	@SuppressWarnings("unused")
	private void init(Context c) {
        LayoutInflater inflate =(LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = Toast.makeText(c, "", Toast.LENGTH_SHORT).getView();
        it = new Toast(c);
        it.setView(v);
    }
       
    public void makeText(Context c,CharSequence text, int duration) {
    	init(c);
        it.setText(text);
        it.setDuration(duration);
        it.show();
    }

    public void makeText(Context c,int Resid, int duration) {
    	init(c);
        it.setText(Resid);
        it.setDuration(duration);
        it.show();
    }
}
