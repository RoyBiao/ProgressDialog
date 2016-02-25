package com.example.test.sharePreferance;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

import android.text.TextUtils;

/**
 * JNI辅助工具类
 * @author saint
 *
 */
public class YiParamsExt {
	protected Map<String, String> mParams;

	public YiParamsExt() {
		mParams = new HashMap<String, String>();
	}

	public Map<String, String> getParams() {
		return mParams;
	}

	public void clear() {
		mParams.clear();
	}

	public void addParam(String key, String value) {
		mParams.put(key, value);
	}

	public void addParam(String key, char value) {
		mParams.put(key, String.valueOf(value));
	}

	public void addParam(String key, boolean value) {
		mParams.put(key, String.valueOf(value));
	}

	public void addParam(String key, int value) {
		mParams.put(key, String.valueOf(value));
	}

	public void addParam(String key, short value) {
		mParams.put(key, String.valueOf(value));
	}

	public void addParam(String key, long value) {
		mParams.put(key, String.valueOf(value));
	}

	public void addParam(String key, float value) {
		mParams.put(key, String.valueOf(value));
	}

	public void addParam(String key, double value) {
		mParams.put(key, String.valueOf(value));
	}

	public String getParam(String key) {
		String ret = mParams.get(key);
		if(TextUtils.isEmpty(ret)) {
			return "";
		}
		return ret;
	}

	public char getCharParam(String key) {
		try {
			String v = getParam(key);
			return Character.valueOf(v.charAt(0));
		} catch (Exception e) {
			return 0;
		}
	}

	public boolean getBooleanParam(String key) {
		try {
			String v = getParam(key);
			return Boolean.valueOf(v);
		} catch (Exception e) {
			return false;
		}
	}

	public int getIntParam(String key) {
		try {
			String v = getParam(key);
			return Integer.valueOf(v);
		} catch (Exception e) {
			return 0;
		}
	}

	public short getShortParam(String key) {
		try {
			String v = getParam(key);
			return Short.valueOf(v);
		} catch (Exception e) {
			return 0;
		}
	}

	public long getLongParam(String key) {
		try {
			String v = getParam(key);
			return Long.valueOf(v);
		} catch (Exception e) {
			return 0L;
		}
	}

	public float getFloatParam(String key) {
		try {
			String v = getParam(key);
			return Float.valueOf(v);
		} catch (Exception e) {
			return 0.0F;
		}
	}

	public double getDoubleParam(String key) {
		try {
			String v = getParam(key);
			return Double.valueOf(v);
		} catch (Exception e) {
			return 0.0;
		}
	}

	public String paramsToJson() throws Exception {
		JSONObject obj = new JSONObject();
		try {
			Set<String> keys = mParams.keySet();
			for (String key : keys) {
				obj.put(key, mParams.get(key));
			}
		} catch (Exception e) {
			throw e;
		}
		return obj.toString();
	}

	@SuppressWarnings("unchecked")
	public void paramsFromJson(String json) throws Exception {
		try {
			JSONObject obj = new JSONObject(json);

			Iterator<String> keys = obj.keys();
			while (keys.hasNext()) {
				String key = keys.next();

				String s = obj.optString(key, null);
				if (s != null) {
					mParams.put(key, s);
				}
			}
		} catch (Exception e) {
			throw e;
		}
	}
}
