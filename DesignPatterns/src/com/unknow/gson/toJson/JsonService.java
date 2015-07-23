package com.unknow.gson.toJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.unknow.gson.Person;

public class JsonService {

	public JsonService() {
	}

	public static Person getPerson() {
		Person person = new Person(1001, "jack", "beijing");
		return person;
	}
	

	public static List<Person> getlistPerson() {
		List<Person> list = new ArrayList<Person>();
		Person person1 = new Person(1001, "jack", "guangxi");
		Person person2 = new Person(1002, "rose", "guangdong");
		list.add(person1);
		list.add(person2);
		return list;
	}
	
	public static Map<String, Object> getMaps() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", "1001");
		map.put("name", "jack");
		map.put("address", "beijing");
		return map;
	}

	public static List<String> getListString() {
		List<String> list = new ArrayList<String>();
		list.add("beijing");
		list.add("shanghai");
		list.add("hunan");
		return list;
	}

	public static List<Map<String, Object>> getListMaps() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("id", 1001);
		map1.put("name", "jack");
		map1.put("address", "beijing");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("id", 1002);
		map2.put("name", "rose");
		map2.put("address", "guangdong");
		list.add(map1);
		list.add(map2);
		return list;
	}

	public static List<Person> objectInListObject(){
		List<Person> list = new ArrayList<Person>();
		
		Person person1 = new Person(1001, "jack", "guangxi");
		List<Person> list1 = new ArrayList<Person>();
		
		Person p1_1 = new Person(1001, "jack", "guangxi");
		List<Person> list1_1 = new ArrayList<Person>();
		Person p1_1_1 = new Person(1001, "jack", "guangxi");
		Person p1_1_2 = new Person(1002, "rose", "guangdong");
		list1_1.add(p1_1_1);
		list1_1.add(p1_1_2);
		p1_1.setpList(list1_1);
		
		Person p1_2 = new Person(1002, "rose", "guangdong");
		list1.add(p1_1);
		list1.add(p1_2);
		person1.setpList(list1);
		list.add(person1);
		
		
		Person person2 = new Person(1002, "rose", "guangdong");
		List<Person> list2 = new ArrayList<Person>();
		Person p2_1 = new Person(1001, "jack", "guangxi");
		Person p2_2 = new Person(1002, "rose", "guangdong");
		list2.add(p2_1);
		list2.add(p2_2);
		person2.setpList(list2);
		list.add(person2);
		
		return list;
	}

}
