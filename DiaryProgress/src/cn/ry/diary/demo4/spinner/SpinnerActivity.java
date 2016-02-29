package cn.ry.diary.demo4.spinner;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.ry.diary.R;

public class SpinnerActivity extends Activity {

	private EditText et_name;
	private ImageView spinner;
	private ArrayList<String> qqName;
	
	private PopupWindow pop;
	private MyAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_spinner);
		
		initData();
		initView();
	}

	private void initData() {
		//qq账号
		qqName = new ArrayList<String>();
		for (int i = 10000; i < 10020; i++) {
			qqName.add(i+"");
		}
		
	}

	private void initView() {
		et_name = (EditText) findViewById(R.id.et_name);
		spinner = (ImageView) findViewById(R.id.spinner);
		
		spinner.setOnClickListener(new OnClickListener() {
			


			@Override
			public void onClick(View arg0) {
				//下拉列表显示
				
				ListView listView = new ListView(getApplicationContext());
				adapter = new MyAdapter();
				listView.setAdapter(adapter);
				listView.setCacheColorHint(0x00000000);
				listView.setVerticalScrollBarEnabled(false);
				
				pop = new PopupWindow(listView, et_name.getWidth(), LayoutParams.WRAP_CONTENT, true);
				//设置·背景色
				pop.setBackgroundDrawable(new ColorDrawable(0x00000000));//透明色
				
				pop.showAsDropDown(et_name, 0, 0);
			}
		});
	}
	
	private class MyAdapter extends BaseAdapter {

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return qqName.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return qqName.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(final int postion, View convertView, ViewGroup parent) {
			//加载布局
			//View view = View.inflate(getApplicationContext(), R.layout.item, null);
			//inflater.inflate(resource, parent)   共同与上面方法
			
			LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
			View view = inflater.inflate(R.layout.item_spinner, parent, false);
			
			//----------------------
			TextView title = (TextView) view.findViewById(R.id.title);
			ImageButton delete = (ImageButton) view.findViewById(R.id.delete);
			
			//设置QQ号码
			title.setText(qqName.get(postion));
			
			title.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					//设置显示点击的qq号码
					et_name.setText(qqName.get(postion));
					pop.dismiss();
				}
			});
			
			delete.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					qqName.remove(postion);
					adapter.notifyDataSetChanged();
				}
			});
			
			return view;
		}
		
	}


}
