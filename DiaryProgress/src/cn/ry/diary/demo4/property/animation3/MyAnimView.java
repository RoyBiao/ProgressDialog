package cn.ry.diary.demo4.property.animation3;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import cn.ry.diary.demo4.property.animation2.Point;
import cn.ry.diary.demo4.property.animation2.PointEvaluator;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.animation.ValueAnimator;


public class MyAnimView extends View {  
  
    public static final float RADIUS = 50f;  
    private String color;
    private Point currentPoint;  
  
    private Paint mPaint;  
  
    public MyAnimView(Context context, AttributeSet attrs) {  
        super(context, attrs);  
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);  
        mPaint.setColor(Color.BLUE);  
    }  
  
    @Override  
    protected void onDraw(Canvas canvas) {  
        if (currentPoint == null) {  
        	System.out.println("currentPoint == null");
            currentPoint = new Point(RADIUS, RADIUS);  
            drawCircle(canvas);  
            startAnimation();  
        } else {  
        	System.out.println("currentPoint != null");
            drawCircle(canvas);  
        }  
    }  
  
    private void drawCircle(Canvas canvas) {  
        float x = currentPoint.getX();  
        float y = currentPoint.getY();  
        canvas.drawCircle(x, y, RADIUS, mPaint);  
    }  
  
    private void startAnimation() {  
    	 Point startPoint = new Point(RADIUS, RADIUS);  
         Point endPoint = new Point(getWidth() - RADIUS, getHeight() - RADIUS);  
         ValueAnimator anim = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint,startPoint);  
         anim.setRepeatCount(Animation.INFINITE);
         anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {  
             @Override  
             public void onAnimationUpdate(ValueAnimator animation) {  
                 currentPoint = (Point) animation.getAnimatedValue();  
                 invalidate();  
             }  
         });  
         ObjectAnimator anim2 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(),   
                 "#0000FF", "#FF0000","#0000FF");  
         anim2.setRepeatCount(Animation.INFINITE);
         AnimatorSet animSet = new AnimatorSet(); 
         animSet.play(anim).with(anim2);  
         animSet.setDuration(5000);  
         animSet.start();  
    }  
    
    public String getColor() {  
        return color;  
    }  
  
    public void setColor(String color) {  
        this.color = color;  
        mPaint.setColor(Color.parseColor(color));  
        invalidate();  
    }  
  
}  