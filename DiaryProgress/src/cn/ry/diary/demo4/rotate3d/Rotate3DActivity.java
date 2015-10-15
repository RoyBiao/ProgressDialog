package cn.ry.diary.demo4.rotate3d;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import cn.ry.diary.R;

public class Rotate3DActivity extends Activity {

	private ViewGroup mviewGroup;
	private ImageView image2;
	private ImageView image1;
	private Rotate3D rotate3d;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rorate3d);
		mviewGroup = (ViewGroup) this.findViewById(R.id.container);
		image1 = (ImageView) this.findViewById(R.id.image1);
		image2 = (ImageView) this.findViewById(R.id.image2);

		rotate3d = new Rotate3D(mviewGroup, image1, image2);
		image1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rotate3d.applyRotation(1, 0, 90);
			}
		});
		image2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				rotate3d.applyRotation(-1, 180, 90);
			}
		});

	}

}
