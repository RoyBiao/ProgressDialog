package com.example.test.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.R;


public class HsDialog {

	private static Dialog mdialog;
	private static TextView mMsgProgressDialog;
	private static TextView mMsg_title;
	private static TextView mMsg_content;
	private static Button mMsg_left;
	private static Button mMsg_right;
	
	
	private static void initDialog(Context context,int layoutResID){
		if(mdialog!=null){
			mdialog.dismiss();
		}
		mdialog=new Dialog(context,R.style.DialogNoTitle);
		mdialog.setContentView(layoutResID);
		mMsg_title = (TextView) mdialog.findViewById(R.id.msg_dialog_title);
		mMsg_content = (TextView) mdialog.findViewById(R.id.msg_dialog_detail_msg);
		mMsg_left = (Button) mdialog.findViewById(R.id.msg_dialog_btn_left);
		mMsg_right = (Button) mdialog.findViewById(R.id.msg_dialog_btn_right);
		
		DisplayMetrics dm = context.getResources().getDisplayMetrics();
		Window window = mdialog.getWindow();
		WindowManager.LayoutParams params = window.getAttributes();
		params.width = dm.widthPixels * 3/ 4;
		params.height = WindowManager.LayoutParams.WRAP_CONTENT;
		window.setAttributes(params);
		
	}

	public static void ShowDialog(Context context,String title,String content,String left,String right,OnClickListener leftOnClik,OnClickListener rightOnClik){
		initDialog(context,R.layout.yi_dialog_template);
		
		mMsg_title.setText(title);
		mMsg_content.setText(content);
		mMsg_left.setText(left);
		mMsg_right.setText(right);
		mMsg_left.setOnClickListener(leftOnClik);
		mMsg_right.setOnClickListener(rightOnClik);
		
		mdialog.show();
	}
	
	public static void ShowDialog(Context context,String title,String content,String right,OnClickListener rightOnClik){
		initDialog(context,R.layout.yi_dialog_template);
		
		mMsg_left.setVisibility(View.GONE);
		
		mMsg_title.setText(title);
		mMsg_content.setText(content);
		mMsg_right.setText(right);
		
		mMsg_right.setOnClickListener(rightOnClik);
		
		mdialog.show();
	}
	
	public static void ShowDialog(Context context,String content){
		initDialog(context,R.layout.yi_dialog_template);
		
		mMsg_title.setVisibility(View.GONE);
		mMsg_left.setVisibility(View.GONE);
		
		mMsg_content.setText(content);
		mMsg_right.setText("确定");
		mMsg_right.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mdialog.dismiss();
			}
		});
		mdialog.show();
	}
	
	public static void showProgressDialog(Context context,String text){
		initDialog(context,R.layout.yi_progress_dialog_template);
		mMsgProgressDialog = (TextView) mdialog.findViewById(R.id.progress_dialog_msg);
		mMsgProgressDialog.setText(text);
		mdialog.show();
	}
	
	
	public static void setMsgProgressDialog(String text){
		mMsgProgressDialog.setText(text);
	}
	
	public static void dismiss(){
		mdialog.dismiss();
	}
	
	
	

}
