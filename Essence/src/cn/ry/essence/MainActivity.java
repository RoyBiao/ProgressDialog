package cn.ry.essence;

import cn.ry.essence.demo01.Demo01Activity;
import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	public void demoOnClick(View view){
		switch (view.getId()) {
		case R.id.demo01:
			startActivity(new Intent(this, Demo01Activity.class));
			break;
		default:
			break;
		}
	}
}
