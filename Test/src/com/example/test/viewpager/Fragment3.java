package com.example.test.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.R;


public class Fragment3 extends Fragment{
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragment3, container, false);
		final ImageView imageView=(ImageView) view.findViewById(R.id.imageview);
		
		return view;
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
	}
}
