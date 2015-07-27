package com.thinking.collection.demo3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteration2 {

	public static void main(String[] args) {
		List<Integer> li1 = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4));
		List<Integer> li2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8, 9,10,11,12));
		ListIterator<Integer> it1 = li1.listIterator(5);
		ListIterator<Integer> it2 = li2.listIterator();
		System.out.println("li1: " + li1);
		System.out.println("li2: " + li2);
		// now use it2 to re-set li2:
		while (it2.hasNext()) {
			it2.next();
			if(it1.hasPrevious()){
				it2.set(it1.previous());
			}
		}
		System.out.println("li1: " + li1);
		System.out.println("li2: " + li2);
	}

}
