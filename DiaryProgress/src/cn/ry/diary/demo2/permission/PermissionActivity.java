package cn.ry.diary.demo2.permission;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import cn.ry.diary.R;

public class PermissionActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_permission);

		PackageManager pm = getPackageManager();
		boolean permission = (PackageManager.PERMISSION_GRANTED == pm
				.checkPermission("android.permission.RECORD_AUDIO",
						"cn.ry.diary"));
		if (permission) {
			System.out.println("有这个权限");
		} else {
			System.out.println("木有这个权限");
		}

	}

}
