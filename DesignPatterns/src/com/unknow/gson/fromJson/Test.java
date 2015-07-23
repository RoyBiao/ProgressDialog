package com.unknow.gson.fromJson;

import java.util.List;
import java.util.Map;

import com.unknow.gson.GsonUtils;
import com.unknow.gson.Person;
import com.unknow.gson.toJson.JsonService;

public class Test {

	public static void main(String[] args) {
		fromJson1();
		fromJson2();
		fromJson3();
		fromJson4();
		fromJson5();
		fromJson6();
	}
	
	private static void fromJson1(){
		Person person = GsonUtils.getObject(GsonUtils.toJsonString(JsonService.getPerson()), Person.class);
		System.out.println(person.toString());
	}
	
	private static void fromJson2(){
		List<Person> persons = GsonUtils.getListObject(GsonUtils.toJsonString(JsonService.getlistPerson()), Person.class);
		System.out.println(persons.toString());
	}
	
	private static void fromJson3(){
		Map<String, Object> map = GsonUtils.getMaps(GsonUtils.toJsonString(JsonService.getMaps()));
		System.out.println(map.toString());
	}
	
	private static void fromJson4(){
		List<String> list = GsonUtils.getListString(GsonUtils.toJsonString(JsonService.getListString()));
		System.out.println(list.toString());
	}
	
	private static void fromJson5(){
		List<Map<String, Object>> maps = GsonUtils.getListMaps(GsonUtils.toJsonString(JsonService.getListMaps()));
		System.out.println(maps.toString());
	}
	
	private static void fromJson6(){
		List<Person> persons = GsonUtils.getListObject(GsonUtils.toJsonString(JsonService.objectInListObject()), Person.class);
		System.out.println(persons.toString());
	}
}
