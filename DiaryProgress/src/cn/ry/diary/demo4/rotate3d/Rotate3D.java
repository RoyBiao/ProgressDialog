package cn.ry.diary.demo4.rotate3d;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;

public class Rotate3D {
	private ViewGroup mContainer;
	private View view1;
	private View view2;
	public Rotate3D(ViewGroup mContainer,View view1,View view2){
		this.mContainer=mContainer;
		this.view1=view1;
		this.view2=view2;
	}
	/**
     * Setup a new 3D rotation on the container view.
     *
     * @param position the item that was clicked to show a picture, or -1 to show the list
     * @param start the start angle at which the rotation must begin
     * @param end the end angle of the rotation
     */
    public void applyRotation(int position, float start, float end) {
        // Find the center of the container
        final float centerX = mContainer.getWidth() / 2.0f;
        final float centerY = mContainer.getHeight() / 2.0f;

        // Create a new 3D rotation with the supplied parameter
        // The animation listener is used to trigger the next animation
        final Rotate3dAnimation rotation =
                new Rotate3dAnimation(start, end, centerX, centerY, 310.0f, true);
        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new AccelerateInterpolator());
        rotation.setAnimationListener(new DisplayNextView(position));

        mContainer.startAnimation(rotation);
    }

    /**
     * This class listens for the end of the first half of the animation.
     * It then posts a new action that effectively swaps the views when the container
     * is rotated 90 degrees and thus invisible.
     */
    private final class DisplayNextView implements Animation.AnimationListener {
        private final int mPosition;

        private DisplayNextView(int position) {
            mPosition = position;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            mContainer.post(new SwapViews(mPosition));
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /**
     * This class is responsible for swapping the views and start the second
     * half of the animation.
     */
    private final class SwapViews implements Runnable {
        private final int mPosition;

        public SwapViews(int position) {
            mPosition = position;
        }

        public void run() {
            final float centerX = mContainer.getWidth() / 2.0f;
            final float centerY = mContainer.getHeight() / 2.0f;
            Rotate3dAnimation rotation;
            
            if (mPosition > -1) {
                view1.setVisibility(View.GONE);
                view2.setVisibility(View.VISIBLE);
                view2.requestFocus();

                rotation = new Rotate3dAnimation(90, 180, centerX, centerY, 310.0f, false);
            } else {
            	view2.setVisibility(View.GONE);
            	view1.setVisibility(View.VISIBLE);
            	view1.requestFocus();

                rotation = new Rotate3dAnimation(90, 0, centerX, centerY, 310.0f, false);
            }

            rotation.setDuration(500);
            rotation.setFillAfter(true);
            rotation.setInterpolator(new DecelerateInterpolator());

            mContainer.startAnimation(rotation);
        }
    }
    
    /***����
     * ���֣�
     * <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
	    	xmlns:tools="http://schemas.android.com/tools"
	    	android:layout_width="match_parent"
	    	android:layout_height="match_parent"
	    	android:orientation="vertical"
	    	android:id="@+id/container" >
    	<ImageView
	        android:id="@+id/image1"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent"
	        android:src="#fff000" />
    	<ImageView
	        android:id="@+id/image2"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent"
	        android:src="#000fff"
	        android:visibility="gone" />
		</LinearLayout>
     * java���룺
     *  private ViewGroup mviewGroup;
		private ImageView image2;
		private ImageView image1;
		private Rotate3D rotate3d;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
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
     */
}
