package cn.ry.diary.demo2.guideview;

import cn.ry.diary.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class GuideViewActivity extends Activity {
	ButtonClickGuideOverlay mGuideOverlay;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_view);
        mGuideOverlay = (ButtonClickGuideOverlay) findViewById(R.id.overlay);
        mButton = (Button) findViewById(R.id.button);
        mButton.postDelayed(new Runnable() {
            @Override
            public void run() {
                showButtonGuideOverlay();
            }
        }, 300);
    }
	
	private void showButtonGuideOverlay() {
        int paddingHorizontal = mButton.getWidth() / 5;
        int paddingVertical = mButton.getHeight() / 4;
        float left = mButton.getX() + paddingHorizontal;
        float right = mButton.getRight() - paddingHorizontal;
        float top = mButton.getY() - paddingVertical;
        float bottom = mButton.getBottom() + paddingVertical;
        mGuideOverlay.show(new Shape.Oval(left, top, right, bottom));
    }
}
