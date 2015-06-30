package cn.ry.diary.demo2.inflater;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import cn.ry.diary.R;

public class LayoutInflaterActivity extends Activity{
	 private LayoutInflater mInflater;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		mInflater = LayoutInflater.from(this);  
		  
        View view1 = mInflater.inflate(R.layout.activity_inflater, null);  
        View view2 = mInflater.inflate(R.layout.activity_inflater,  
                (ViewGroup)findViewById(android.R.id.content), false);  
        View view3 = mInflater.inflate(R.layout.activity_inflater,  
                (ViewGroup)findViewById(android.R.id.content), true);  
  
        Log.e("TAG", "view1 = " + view1  +" , view1.layoutParams = " + view1.getLayoutParams());  
        Log.e("TAG", "view2 = " + view2  +" , view2.layoutParams = " + view2.getLayoutParams());  
        Log.e("TAG", "view3 = " + view3  );  
	}
}
