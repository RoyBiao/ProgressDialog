package cn.ry.diary.demo3.cusorloader;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import cn.ry.diary.R;

public class CusorLoaderActivity extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cusor_loader);
		
		FragmentManager fragmentManager =getSupportFragmentManager();
		FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
		fragmentTransaction.add(R.id.fragment1, new MyCursorLoaderListFragment());
		fragmentTransaction.commit();
	}
}
