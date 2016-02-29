package com.example.test.viewpager;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

/**
 * 
 * @author 黄松炎 修改  ViewPager适配器
 */
public class FragPagerAdapter extends FragmentPagerAdapter {

	// Fragment列表
	private List<Fragment> mFragmentsList;

	public FragPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	public FragPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
		super(fm);
		this.mFragmentsList = fragments;
	}

	@Override
	public int getCount() {
		return mFragmentsList != null ? mFragmentsList.size() : 0;
	}

	@Override
	public Fragment getItem(int position) {
		return mFragmentsList != null && mFragmentsList.size() > 0 ? mFragmentsList
				.get(position) : null;
	}

	@Override
	public int getItemPosition(Object object) {
		return super.getItemPosition(object);
	}

	
	
	

	
}
