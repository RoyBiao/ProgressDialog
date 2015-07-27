package com.thinking.collection.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class SimpleIteration2 {

	public static void printAny(Collection c) {
		Iterator it = c.iterator();
		while(it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayList<Integer> al = 
			new ArrayList<Integer>(Arrays.asList(1, 2, 3));
		LinkedList<Character> ll =
			new LinkedList<Character>(Arrays.asList('a', 'b', 'c'));	
		HashSet<Float> hs = 
			new HashSet<Float>(Arrays.asList(1.1f, 2.2f, 3.3f));
		TreeSet<Double> ts =
			new TreeSet<Double>(Arrays.asList(1.11, 2.22, 3.33));
		LinkedHashSet<Integer> lhs =
			new LinkedHashSet<Integer>(Arrays.asList(11, 22, 33));
		printAny(al);
		printAny(ll);
		printAny(hs);
		printAny(ts);
		printAny(lhs);
	}
}
