package cn.ry.diary.demo2.guideview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.ry.diary.R;


/**
 * Created by qluan on 2015/3/27.
 */
public class ButtonClickGuideOverlay extends RelativeLayout implements AbsGuideOverlay, View.OnClickListener{
    public OverlayView mOverlayView;
    public View mContent;
    public ImageView mImageView;
    public TextView mMessage;

    public ButtonClickGuideOverlay(Context context) {
        super(context);
        init();
    }

    public ButtonClickGuideOverlay(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ButtonClickGuideOverlay(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext())
                .inflate(R.layout.view_overlay, this, true);
        mOverlayView = (OverlayView) view.findViewById(R.id.overlay_view);
        mContent = (View) view.findViewById(R.id.overlay_content);
        mImageView = (ImageView) view.findViewById(R.id.overlay_content_image);
        mMessage = (TextView) view.findViewById(R.id.overlay_content_text);
        setOnClickListener(this);
    }

    @Override
    public void hide() {
        setVisibility(View.GONE);
    }

    @Override
    public void show(Shape shape) {
        if (null == shape) {
            return;
        }
        resetContent(shape);
        setVisibility(View.VISIBLE);
    }

    private void resetContent(Shape shape) {
        mOverlayView.setShape(shape);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) mContent.getLayoutParams();
        if (null == layoutParams) {
            layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        layoutParams.topMargin = (int) shape.getBottom();
        mContent.setLayoutParams(layoutParams);
    }

    @Override
    public void onClick(View v) {
        if (null == v) {
            return;
        }
        hide();
    }
}
