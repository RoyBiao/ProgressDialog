package cn.ry.diary.demo.custom.drawable;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import cn.ry.diary.R;
import cn.ry.diary.demo.custom.drawable.widge.CircleImageDrawable;

public class CircleImageDrawableActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_drawable);

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.mv);
		ImageView iv = (ImageView) findViewById(R.id.id_one);
		iv.setImageDrawable(new CircleImageDrawable(bitmap));
		iv = (ImageView) findViewById(R.id.id_two);
		iv.setImageDrawable(new CircleImageDrawable(bitmap));

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
