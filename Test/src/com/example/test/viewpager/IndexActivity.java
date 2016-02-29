package com.example.test.viewpager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.example.R;

public class IndexActivity extends FragmentActivity implements OnPageChangeListener,OnCheckedChangeListener{
	private ViewPager mViewPager;
	// 底部tab
	private RadioGroup mRadioGroup;
	private RadioButton mConversation;
	private RadioButton mFriend;
	private RadioButton mMine;
	// viewPager的容器
	private List<Fragment> mList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_index);

		mViewPager = (ViewPager) findViewById(R.id.viewpager);
		mViewPager.setOffscreenPageLimit(2);
		mRadioGroup = (RadioGroup) findViewById(R.id.main_tab);
		mConversation = (RadioButton) findViewById(R.id.main_tab_conversation);
		mFriend = (RadioButton) findViewById(R.id.main_tab_friend);
		mMine = (RadioButton) findViewById(R.id.main_tab_mine);
		
		mList = new ArrayList<Fragment>();
		Fragment fragment1=new Fragment1();
		mList.add(fragment1);
		Fragment fragment2=new Fragment2();
		mList.add(fragment2);
		Fragment fragment3=new Fragment3();
		mList.add(fragment3);
		FragPagerAdapter adapter=new FragPagerAdapter(getSupportFragmentManager(), mList);
		mViewPager.setAdapter(adapter);
		
		mViewPager.setOnPageChangeListener(this);
		mRadioGroup.setOnCheckedChangeListener(this);
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		
	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		
	}

	@Override
	public void onPageSelected(int arg0) {
		if (arg0 == 0) {
			mConversation.setChecked(true);
		} else if (arg0 == 1) {
			mFriend.setChecked(true);
		} else if (arg0 == 2) {
			mMine.setChecked(true);
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		switch (checkedId) {
		case R.id.main_tab_conversation:
			mViewPager.setCurrentItem(0);
			break;
		case R.id.main_tab_friend:
			mViewPager.setCurrentItem(1);
			break;
		case R.id.main_tab_mine:
			mViewPager.setCurrentItem(2);
			break;
		}
	}
}
