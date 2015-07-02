package cn.ry.diary.demo2.guideview2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import cn.ry.diary.R;

public class GuideView2Activity extends BasicActivity{
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_view2);
        
        Button btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                
            }
            
        });
        
        
        
        setGuideResId(R.drawable.guide_view);//添加引导页
    }
}
