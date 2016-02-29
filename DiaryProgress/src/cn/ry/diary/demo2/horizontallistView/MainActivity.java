package cn.ry.diary.demo2.horizontallistView;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import cn.ry.diary.R;
import cn.ry.diary.common.widget.HorizontalListView;

public class MainActivity extends Activity {
	HorizontalListView hListView;
	HorizontalListViewAdapter hListViewAdapter;
	ImageView previewImg;
	View olderSelectView = null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_horizontal_listview);
		initUI();
		//AseoZdpAseo.init(this, AseoZdpAseo.INSERT_TYPE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	public void initUI(){
		hListView = (HorizontalListView)findViewById(R.id.horizon_listview);
		previewImg = (ImageView)findViewById(R.id.image_preview);
		String[] titles = {"怀师", "南怀瑾军校", "闭关", "南怀瑾", "南公庄严照", "怀师法相"};
		final int[] ids = {R.drawable.nanhuaijin_miss, R.drawable.nanhuaijin_school,
				R.drawable.nanhuaijin_biguan, R.drawable.nanhuaijin,
				R.drawable.nanhuaijin_zhuangyan, R.drawable.nanhuaijin_faxiang};
		hListViewAdapter = new HorizontalListViewAdapter(getApplicationContext(),titles,ids);
		//AseoZdpAseo.initTimer(this);
		hListView.setAdapter(hListViewAdapter);
		//		hListView.setOnItemSelectedListener(new OnItemSelectedListener() {
		//
		//			@Override
		//			public void onItemSelected(AdapterView<?> parent, View view,
		//					int position, long id) {
		//				// TODO Auto-generated method stub
		//				if(olderSelected != null){
		//					olderSelected.setSelected(false); //上一个选中的View恢复原背景
		//				}
		//				olderSelected = view;
		//				view.setSelected(true);
		//			}
		//
		//			@Override
		//			public void onNothingSelected(AdapterView<?> parent) {
		//				// TODO Auto-generated method stub
		//				
		//			}
		//		});
		hListView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				if(olderSelectView == null){
//					olderSelectView = view;
//				}else{
//					olderSelectView.setSelected(false);
//					olderSelectView = null;
//				}
//				olderSelectView = view;
//				view.setSelected(true);
				previewImg.setImageResource(ids[position]);
				hListViewAdapter.setSelectIndex(position);
				hListViewAdapter.notifyDataSetChanged();
				
			}
		});

	}

}
