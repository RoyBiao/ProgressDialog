package com.example.test2.enums;

import android.test.AndroidTestRunner;

public class TestZQMessage extends AndroidTestRunner{
	
	public void test1(){
		ZQMessage message=new ZQMessage();
		message.setBody("hello");
		
		System.out.println(message.toString());
	}
}
