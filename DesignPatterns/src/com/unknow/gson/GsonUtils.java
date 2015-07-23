package com.unknow.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonUtils {


	/**
	 * @param object
	 *            是对解析的集合的类型
	 * @return
	 */
	public static String toJsonString(Object value) {
		Gson gson = new Gson();
		String str = gson.toJson(value);
		return str;
	}
	
	/**
	 * 获取单个对象
	 * 
	 * @param <T>
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T getObject(String jsonString, Class<T> cls) {
		T t = null;
		try {
			Gson gson = new Gson();
			t = gson.fromJson(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 获取集合对象
	 * 
	 * @param <T>
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> getListObject(String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<T>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString, new TypeToken<List<T>>() {
			}.getType());
		} catch (Exception e) {
		}
		return list;
	}

	/**
	 * 获取字符串集合
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<String> getListString(String jsonString) {
		List<String> list = new ArrayList<String>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString, new TypeToken<List<String>>() {
			}.getType());
		} catch (Exception e) {
		}
		return list;
	}

	/**
	 * 获取多种类型的Map集合
	 * 
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> getListMaps(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		try {
			Gson gson = new Gson();
			list = gson.fromJson(jsonString,
					new TypeToken<List<Map<String, Object>>>() {
					}.getType());
		} catch (Exception e) {
		}
		return list;
	}

	/**
	 * 获取多种类型的Map集合
	 * 
	 * @param jsonString
	 * @return
	 */
	public static Map<String, Object> getMaps(String jsonString) {
		try {
			Gson gson = new Gson();
			return gson.fromJson(jsonString,
					new TypeToken<Map<String, Object>>() {
					}.getType());
		} catch (Exception e) {
		}
		return new HashMap<String, Object>();
	}
}
