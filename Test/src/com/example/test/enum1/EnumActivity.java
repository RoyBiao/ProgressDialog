package com.example.test.enum1;

import android.app.Activity;
import android.gesture.GestureOverlayView;
import android.gesture.GestureOverlayView.OnGestureListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.R;
import com.example.test.toast.MyToast;

public class EnumActivity extends Activity implements OnGestureListener{
	private GestureOverlayView mGestureOverlayView;
	private Button mLeftButton, mRightButton;
	private TextView mHeaderMsg;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_enum);
		
		//getActionBar().setTitle(R.string.draw_gesture); 
		
		//获取相关组件对象  
        mGestureOverlayView = (GestureOverlayView) findViewById(R.id.gesture);  
        mLeftButton = (Button)findViewById(R.id.left);  
        mRightButton = (Button)findViewById(R.id.right);  
        mHeaderMsg = (TextView)findViewById(R.id.header);
        
        //注册手势相关监听器  
        mGestureOverlayView.addOnGestureListener(this);  
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	//该方法的定义重点在于说明枚举类型能在switch语句中的活用(比如，我们可以根据传递的枚举进行监听操作某些事件)  
    private void monitorChange(Stage stage)  
    {  
        switch (stage) {  
        case Introduction:  
            MyToast.builder.makeText(this, "App onResume", Toast.LENGTH_SHORT);  
            break;  
        case Ready:  
        	MyToast.builder.makeText(this, "onGestureStarted", Toast.LENGTH_SHORT);  
            break;  
        case Gesturing:  
        	MyToast.builder.makeText(this, "onGesture", Toast.LENGTH_SHORT);  
            break;  
        case Finish:  
        	MyToast.builder.makeText(this, "onGestureEnded", Toast.LENGTH_SHORT);  
            break;  
        }  
    }  
    
    //根据传进来的枚举Stage设置和显示按钮的状态  
    private void setButtunStatus(Stage stage)  
    {  
        mHeaderMsg.setText(stage.headerMessage);  
        mLeftButton.setText(stage.leftMode.text);  
        mLeftButton.setEnabled(stage.leftMode.enabled);  
        mRightButton.setText(stage.rightMode.text);  
        mRightButton.setEnabled(stage.rightMode.enabled);  
    }  
    
    // 开始画手势时调用（即用户手指点住屏幕还没开始滑动时调用） 
	@Override
	public void onGestureStarted(GestureOverlayView overlay, MotionEvent event) {
		//准备画手势时更新按钮状态  
        setButtunStatus(Stage.Ready);  
        monitorChange(Stage.Ready); 
	}
	// 正在画手势时调用该函数	
	@Override
	public void onGesture(GestureOverlayView overlay, MotionEvent event) {
		//在画手势的过程中，更新按钮的状态  
        setButtunStatus(Stage.Gesturing);  
        monitorChange(Stage.Gesturing);
	}
	// 画完手势时调用 
	@Override
	public void onGestureEnded(GestureOverlayView overlay, MotionEvent event) {
		//画完手势更新按钮状态  
        setButtunStatus(Stage.Finish);  
        monitorChange(Stage.Finish); 
	}
	@Override
	public void onGestureCancelled(GestureOverlayView overlay, MotionEvent event) {
		
	}
	
	// 定义左边按钮各状态的枚举，注：构造函数和成员变量的位置都要放在后面  
    private enum LeftButtonMode {  
        // 按钮显示为取消、可点击状态的枚举对象(枚举对象意味个人说法)  
        Cancel(R.string.cancel, true),  
        // 按钮显示为取消、不可点击状态  
        CancelDisabled(R.string.cancel, false),  
        // 按钮显示为重试、可点击状态  
        Retry(R.string.retry, true),  
        // 按钮显示为重试、不可点击状态  
        RetryDisabled(R.string.retry, false);  
  
        LeftButtonMode(int text, boolean enabled) {  
            this.text = text;  
            this.enabled = enabled;  
        }  
  
        final int text;  
        final boolean enabled;  
    } 
    
	// 定义右边按钮各状态的枚举  
    private enum RightButtonMode {  
        Continue(R.string.next, true),   
        ContinueDisabled(R.string.next, false),   
        Confirm(R.string.confirm, true),   
        ConfirmDisabled(R.string.confirm,false);  
  
        RightButtonMode(int text, boolean enabled) {  
            this.text = text;  
            this.enabled = enabled;  
        }  
  
        final int text;  
        final boolean enabled;  
    }  
    
    //统筹左右按钮状态的枚举，可以理解为枚举的复用(将左右按钮的状态枚举作为实参传递)  
    private enum Stage {  
  
        Introduction(R.string.gesture_introdution, LeftButtonMode.Cancel,  
                RightButtonMode.Confirm),             
        Ready(  
                R.string.gesture_ready, LeftButtonMode.CancelDisabled,  
                RightButtonMode.ConfirmDisabled),             
        Gesturing(  
                R.string.gesture_drawing, LeftButtonMode.RetryDisabled,  
                RightButtonMode.ContinueDisabled),            
        Finish(  
                R.string.gesture_finish, LeftButtonMode.Retry,  
                RightButtonMode.Continue);  
  
        Stage(int headerMessage, LeftButtonMode leftMode,  
                RightButtonMode rightMode) {  
            this.headerMessage = headerMessage;  
            this.leftMode = leftMode;  
            this.rightMode = rightMode;  
        }  
  
        final int headerMessage;  
        final LeftButtonMode leftMode;  
        final RightButtonMode rightMode;  
    } 
}
