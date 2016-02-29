package cn.ry.diary.demo.custom.drawable;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import cn.ry.diary.R;
import cn.ry.diary.demo.custom.drawable.widge.MessageListItem;

public class CustomStateDrawableActivity extends ListActivity
{
	private MyMessage[] messages = new MyMessage[] {
			new MyMessage("Gas bill overdue", true),
			new MyMessage("Congratulations, you've won!", true),
			new MyMessage("I love you!", false),
			new MyMessage("Please reply!", false),
			new MyMessage("You ignoring me?", false),
			new MyMessage("Not heard from you", false),
			new MyMessage("Electricity bill", true),
			new MyMessage("Gas bill", true), new MyMessage("Holiday plans", false),
			new MyMessage("Marketing stuff", false), };

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		getListView().setAdapter(new ArrayAdapter<MyMessage>(this, -1, messages)
		{
			private LayoutInflater mInflater = LayoutInflater
					.from(getContext());

			@Override
			public View getView(int position, View convertView, ViewGroup parent)
			{
				if (convertView == null)
				{
					convertView = mInflater.inflate(R.layout.item_msg_list,
							parent, false);
				}
				MessageListItem messageListItem = (MessageListItem) convertView;
				TextView tv = (TextView) convertView
						.findViewById(R.id.id_msg_item_text);
				tv.setText(getItem(position).message);
				messageListItem.setMessageReaded(getItem(position).readed);
				return convertView;
			}

		});

	}
}
