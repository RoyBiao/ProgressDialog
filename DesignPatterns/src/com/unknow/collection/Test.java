package com.unknow.collection;

import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;


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
		
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance("com.liulutu.student.model");
		} catch (JAXBException e) {
			e.printStackTrace();
		}  
	}
}
