//: holding/SimpleCollection.java
package com.thinking.collection.demo1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class SimpleCollection {
	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
		Collection<Integer> c1 = new HashSet<Integer>();
		// Set<Integer> c =new HashSet<Integer>();
		for (int i = 0; i < 10; i++)
			c.add(i); // Autoboxing
		c.add(9);
		for (Integer i : c)
			System.out.print(i + ", ");
		
		//List<String> a =new ArrayList<>();
		//ArrayList<String> b = new ArrayList<>();
	}
} /*
 * Output: 0, 1, 2, 3, 4, 5, 6, 7, 8, 9,
 */// :~
