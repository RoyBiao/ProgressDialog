package com.example.test.threadpool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.example.R;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_threadpool);
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void button1(View view){
		startActivity(new Intent(this, ThreadActivity1.class));
	}
	
	public void button2(View view){
		startActivity(new Intent(this, ThreadActivity2.class));
	}
	
	public void button3(View view){
		startActivity(new Intent(this, ThreadActivity3.class));
	}
	
	public void button4(View view){
		startActivity(new Intent(this, ThreadActivity4.class));
	}

}
