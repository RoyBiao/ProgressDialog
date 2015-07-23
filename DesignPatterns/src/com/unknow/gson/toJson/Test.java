package com.unknow.gson.toJson;

import com.unknow.gson.GsonUtils;

public class Test {
	
	public static void main(String[] args) {
		data1();
		data2();
		data3();
		data4();
		data5();
		data6();
	}
	
	private static void data1(){
		String data = GsonUtils.toJsonString(JsonService.getPerson());
		System.out.println("data1:"+data);
	}

	private static void data2(){
		String data = GsonUtils.toJsonString(JsonService.getlistPerson());
		System.out.println("data2:"+data);
	}

	private static void data3(){
		String data = GsonUtils.toJsonString(JsonService.getMaps());
		System.out.println("data3:"+data);
	}
	
	private static void data4(){
		String data = GsonUtils.toJsonString(JsonService.getListString());
		System.out.println("data4:"+data);
	}
	
	
	private static void data5(){
		String data = GsonUtils.toJsonString(JsonService.getListMaps());
		System.out.println("data5:"+data);
	}
	
	private static void data6(){
		String data = GsonUtils.toJsonString(JsonService.objectInListObject());
		System.out.println("data6:"+data);
	}
	
}
