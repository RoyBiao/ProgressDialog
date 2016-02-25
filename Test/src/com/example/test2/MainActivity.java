package com.example.test2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.R;
import com.example.test2.pinyin.PinYin;
import com.example.test2.shape.ShapeActivity;
import com.example.test2.sortlistview.SortListViewActivity;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main2);
	}

	public void sortListView(View view) {
		startActivity(new Intent(this, SortListViewActivity.class));
	}

	public void HanZiToPinYin(View view) {
		String pinyin = PinYin.getPinYin("单赵 钱 孙 李 周 吴 郑 王冯 陈 褚 卫 蒋 沈 韩 杨 朱");
		Toast.makeText(this, "pinyin:" + pinyin, 0).show();
	}
	
	public void shape(View view) {
		startActivity(new Intent(this, ShapeActivity.class));
	}
}
