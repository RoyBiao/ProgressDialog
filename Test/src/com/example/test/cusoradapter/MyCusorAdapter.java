package com.example.test.cusoradapter; 

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.ViewGroup;

/** 
 * 
 * @author liruibiao
 * @version 1.0
 * @date 2015-3-18 下午1:24:48
 */
public class MyCusorAdapter extends CursorAdapter{

	public MyCusorAdapter(Context context, Cursor c, boolean autoRequery) {
		super(context, c, autoRequery);
	}

	public MyCusorAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
	}

	@Override
	public void bindView(View arg0, Context arg1, Cursor arg2) {
		
	}

	@Override
	public View newView(Context arg0, Cursor arg1, ViewGroup arg2) {
		return null;
	}

}
 

