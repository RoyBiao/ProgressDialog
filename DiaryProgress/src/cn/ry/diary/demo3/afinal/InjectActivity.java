package cn.ry.diary.demo3.afinal;

import net.tsz.afinal.FinalActivity;
import net.tsz.afinal.annotation.view.ViewInject;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import cn.ry.diary.R;

public class InjectActivity extends FinalActivity {
	@ViewInject(id = R.id.button,click="btnClick")
	private Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_inject);

		button.setText("Press Button");
	}
	
	public void btnClick(View view){
		Toast.makeText(this, "hahaha", 1000).show();
	}
}
