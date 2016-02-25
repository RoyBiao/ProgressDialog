package com.example.test2.pinyin2;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;


public class TestActivity extends Activity {
    /** Called when the activity is first created. */
	TextView tView;
   
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tView=new TextView(this);
        tView.setTextSize(24);
        tView.setTextColor(Color.WHITE);
        String hanziString="��";
        try {
			String pinyinString= HanZiToPinYin.toPinYin(hanziString.charAt(0));
			tView.setText("ƴ����"+pinyinString+"\n"+"���֣�"+hanziString);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        setContentView(tView);
    }
}