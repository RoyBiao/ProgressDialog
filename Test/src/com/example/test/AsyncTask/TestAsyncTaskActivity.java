package com.example.test.AsyncTask; 

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.R;

/** 
 * 
 * @author liruibiao
 * @version 1.0
 * @date 2015-3-10 下午1:08:39
 */
public class TestAsyncTaskActivity extends Activity {
	private Button button;  
    private ProgressBar progressBar;  
    private TextView textView;  	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_asynctask); 
		button = (Button)findViewById(R.id.button03);  
        progressBar = (ProgressBar)findViewById(R.id.progressBar02);  
        textView = (TextView)findViewById(R.id.textView01);  
        progressBar.setMax(200);
        button.setOnClickListener(new OnClickListener() {  
              
            @Override  
            public void onClick(View v) {  
                ProgressBarAsyncTask asyncTask = new ProgressBarAsyncTask(textView, progressBar);  
                asyncTask.execute(1000);  
            }  
        });  
	}
}
 

