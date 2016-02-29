package com.example.test.sharePreferance;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Base64;

import com.example.test.sharePreferance.HsPrefsKeeper.HSPrefsKeepable;


public class HsUserInfo implements HSPrefsKeepable {
	private static final String USERINFO_PREFS_NAME = "hs_us_";

	// 用户名
	private String mUserName;
	// 密码
	private String mPassword;
	// 启用记住密码
	private boolean mEnableRememberPassword;
	// 启用自动登录
	private boolean mEnableAutoLogin;
	// 用户是否是第一次登录，此标识用于当用户第一次登录时做一些必要的初始化工作
	private boolean mIsFirstLogin;

	private static HsUserInfo mUserInfo = null;

	public HsUserInfo(String username) {
		mUserName = username;
		mPassword = null;
	}

	//HSPrefsKeepable接口的save回调方法
	@Override
	public void save(Editor editor) {
		editor.putString("USERNAME", mUserName);
		editor.putBoolean("REMENBER_PASSWORD", mEnableRememberPassword);
		editor.putBoolean("AUTO_LOGIN", mEnableAutoLogin);
		editor.putBoolean("FIRST_LOGIN", mIsFirstLogin);
		if (mEnableRememberPassword) {
			editor.putString("PASSWORD", Base64.encodeToString(
					mPassword.getBytes(), Base64.DEFAULT));
		} else {
			editor.putString("PASSWORD", "");
		}
	}
	
	//HSPrefsKeepable接口的restore回调方法
	@Override
	public void restore(SharedPreferences preferences) {
		mUserName = preferences.getString("USERNAME", null);
		mPassword = preferences.getString("PASSWORD", null);
		mEnableRememberPassword = preferences.getBoolean("REMENBER_PASSWORD",
				false);
		mEnableAutoLogin = preferences.getBoolean("AUTO_LOGIN", false);
		mIsFirstLogin = preferences.getBoolean("FIRST_LOGIN", true);
		if (!TextUtils.isEmpty(mPassword)) {
			mPassword = new String(Base64.decode(mPassword, Base64.DEFAULT));
		}
	}
	//HSPrefsKeepable接口的getPrefsName回调方法
	@Override
	public String getPrefsName() {
		return USERINFO_PREFS_NAME + mUserName;
	}
	
	// 持久保存当前对象	 
	public void persist(Context context) {
		HsPrefsKeeper.write(context, this);
	}
	
	// 获取当前用户的基本信息
	public static  HsUserInfo getUserInfo(Context context) {
		return getUserInfo(context, false);
	}
	private static HsUserInfo getUserInfo(Context context, boolean force) {
		HsPrefsKeeper.read(context, HsUserInfoList.getInstance());
		if (HsUserInfoList.getInstance().getUser() != null
				&& (mUserInfo == null || force)) {
			mUserInfo = new HsUserInfo(HsUserInfoList.getInstance().getUser());
			HsPrefsKeeper.read(context, mUserInfo);
		}
		return mUserInfo;
	}
	
	//获取具体用户的信息
	public static HsUserInfo getUserInfo(Context context, String user) {
		HsUserInfo info = new HsUserInfo(user);
		HsPrefsKeeper.read(context, info);
		return info;
	}

	//将当前用户设置为活跃用户，这样下次调用getUserInfo的时候，获取的就当前用户的信息了。
	public void active(Context context) {
		HsUserInfoList.getInstance().setUser(getmUserName());
		HsPrefsKeeper.write(context, HsUserInfoList.getInstance());
		mUserInfo = this;
	}
	
	
	//Getters and Setters	
	public String getmUserName() {
		return mUserName;
	}
	
	public void setmUserName(String mUserName) {
		this.mUserName = mUserName;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

	public boolean ismEnableRememberPassword() {
		return mEnableRememberPassword;
	}

	public void setmEnableRememberPassword(boolean mEnableRememberPassword) {
		this.mEnableRememberPassword = mEnableRememberPassword;
	}

	public boolean ismEnableAutoLogin() {
		return mEnableAutoLogin;
	}

	public void setmEnableAutoLogin(boolean mEnableAutoLogin) {
		this.mEnableAutoLogin = mEnableAutoLogin;
	}

	public boolean ismIsFirstLogin() {
		return mIsFirstLogin;
	}

	public void setmIsFirstLogin(boolean mIsFirstLogin) {
		this.mIsFirstLogin = mIsFirstLogin;
	}

}
