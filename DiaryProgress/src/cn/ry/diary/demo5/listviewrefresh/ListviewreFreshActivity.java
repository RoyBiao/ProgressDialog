package cn.ry.diary.demo5.listviewrefresh;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import cn.ry.diary.R;

/**
 * listview 局部刷新
 * @author ruibiao
 *
 */
public class ListviewreFreshActivity extends Activity {
	private ArrayList<MyListItem> list = null;
	private ListView lv;
	private MyListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_listview_refresh);
		intitData();
		lv = (ListView) findViewById(R.id.listView1);
		adapter = new MyListAdapter(list, getApplicationContext());
		adapter.setListView(lv);
		lv.setAdapter(adapter);

		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// 获取listview中点击item的数据
				MyListItem item = (MyListItem) parent
						.getItemAtPosition(position);
				Log.i("eee", item.getData() + " == " + item.getPosition());
				// 更新数据
				item.setData("update item " + position);
				// 更新界面
				adapter.updateItemData(item);
			}
		});

	}

	/**
	 * 初始化数据
	 */
	private void intitData() {
		list = new ArrayList<MyListItem>();
		for (int i = 0; i < 20; i++) {
			MyListItem item = new MyListItem();
			item.setData("item " + i);
			item.setPosition(i);
			list.add(item);
		}
	}
}
