package com.example.test.sharePreferance;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class HsPrefsKeeper {

	private HsPrefsKeeper() {

	}

	public static void write(Context context, HSPrefsKeepable v) {
		SharedPreferences preferences = context.getSharedPreferences(
				v.getPrefsName(), Context.MODE_PRIVATE);
		Editor editor = preferences.edit();
		v.save(editor);
		editor.commit();
	}

	public static void read(Context context, HSPrefsKeepable v) {
			SharedPreferences preferences = context.getSharedPreferences(
					v.getPrefsName(), Context.MODE_PRIVATE);
			v.restore(preferences);
	}

	public static void clear(Context context, HSPrefsKeepable v) {
			SharedPreferences preferences = context.getSharedPreferences(
					v.getPrefsName(), Context.MODE_PRIVATE);
			Editor editor = preferences.edit();
			editor.clear();
			editor.commit();
	}

	public interface HSPrefsKeepable {
		void save(Editor editor);

		void restore(SharedPreferences preferences);

		String getPrefsName();
	}
}
