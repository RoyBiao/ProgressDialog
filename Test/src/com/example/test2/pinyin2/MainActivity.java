package com.example.test2.pinyin2;

import java.util.ArrayList;
import java.util.List;

import com.example.R;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	private TextView text;
	private static final int VOICE_RECOGNITION_REQUEST_CODE = 1234;
	private ListView mList;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pinyin);
		text = (TextView) findViewById(R.id.test);
		Button speakButton = (Button) findViewById(R.id.button1);
		String hanziString = "锟斤拷";

		String pinyinString = HanZiToPinYin.toPinYin(hanziString.charAt(0));
		text.setText("拼锟斤拷锟斤拷" + pinyinString + "\n" + "锟斤拷锟街ｏ拷" + hanziString);

		PackageManager pm = getPackageManager();
		List activities = pm.queryIntentActivities(new Intent(
				RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0); // 锟斤拷锟斤拷识锟斤拷锟斤拷锟�
		// new Intent(RecognizerIntent.ACTION_WEB_SEARCH), 0); // 锟斤拷锟斤拷识锟斤拷锟斤拷锟�
		if (activities.size() != 0) {
			speakButton.setOnClickListener(this);
		} else { // 锟斤拷锟斤拷獠伙拷锟斤拷锟斤拷锟绞讹拷锟斤拷锟斤拷锟节憋拷锟斤拷装锟斤拷锟解将扭锟斤拷没锟�
			speakButton.setEnabled(false);
			speakButton.setText("Recognizer not present");
		}

	}

	public void onClick(View v) {
		if (v.getId() == R.id.button1) {
			startMysttActivityActivity();
		}
	}

	private void startMysttActivityActivity() { // 锟斤拷始识锟斤拷
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
				"Speech recognition demo");
		startActivityForResult(intent, VOICE_RECOGNITION_REQUEST_CODE);
		// 锟斤拷锟斤拷识锟斤拷锟斤拷锟�
	}

	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == VOICE_RECOGNITION_REQUEST_CODE
				&& resultCode == RESULT_OK) {
			// Fill the list view with the strings the recognizer thought it
			// could have heard
			ArrayList<String> matches = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

			String ma = matches.get(0);
			String pinyinString = HanZiToPinYin.toPinYin1(ma);
			// String pinyinString=
			// HanZiToPinYin.makeStringByStringSet(HanZiToPinYin.getpinyin(ma));
			text.setText("拼锟斤拷锟斤拷" + pinyinString + "\n" + "锟斤拷锟街ｏ拷" + ma);
			Toast.makeText(this, pinyinString, 0).show();
		}
		// 锟斤拷锟斤拷识锟斤拷锟侥回碉拷锟斤拷锟斤拷识锟斤拷锟斤拷执锟斤拷锟絣ist锟斤拷锟斤拷示
		// super.onActivityResult(requestCode, resultCode, data);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
