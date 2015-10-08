package com.unknow.collection;

import java.util.ArrayList;


public class Test {

	public static void main(String[] args) {
		ArrayList<String> aa =new ArrayList<String>();
		for (int i = 0; i <5; i++) {
			aa.add("aa"+i+1);
		}
		ArrayList<String> bb =new ArrayList<String>();
		bb.add(0, "bb");
		bb.add(1, "bb");
		
		int a=1/2;
		System.out.println(a);
	}
}
