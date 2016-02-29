package com.example.test.sharePreferance;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.R;

public class UserInfoActivity extends Activity{
	
	private TextView mUserInfoTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_userinfo);
		mUserInfoTextView = (TextView) this.findViewById(R.id.userInfoTextView);
		HsUserInfo info=HsUserInfo.getUserInfo(this);
		mUserInfoTextView.append(info.getmUserName()+"\n");
		mUserInfoTextView.append(info.getmPassword());
		
//		YiUserInfo info=YiUserInfo.getUserInfo(this);
//		mUserInfoTextView.append(info.getUserName());
//		mUserInfoTextView.append(info.getPasswd());
	}
}
