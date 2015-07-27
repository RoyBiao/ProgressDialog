package com.thinking.collection.demo3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;

public class LinkedListTest {
	public static void main(String[] args) {
		LinkedList<Integer> list =new LinkedList<Integer>(Arrays.asList(1,2,3,4,5));
		
		ListIterator<Integer> iterator = null;
		for(int i=0;i<10;i++){
			iterator = list.listIterator(list.size()/2);
			//iterator.add(0);
			iterator.next();
			iterator.set(Integer.valueOf(0));
		}
		
		System.out.println(list);
		
		TreeSet<String> set1 = new TreeSet<String>();//°´×ÖµäÅÅÐò
		TreeSet<String> set2 = new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);//°´×ÖÄ¸ÅÅÐò
		
	}
}
