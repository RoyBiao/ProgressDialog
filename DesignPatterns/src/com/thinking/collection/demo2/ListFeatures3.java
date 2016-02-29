//: holding/ListFeatures.java
package com.thinking.collection.demo2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListFeatures3 {
	public static void main(String[] args) {
		Random rand = new Random(47);

		List<String> pets = new ArrayList<String>(Arrays.asList("1", "2", "3",
				"4", "5", "6", "7", "8"));
		System.out.println("1: " + pets);
		pets.add("9"); // Automatically resizes
		System.out.println("2: " + pets);
		System.out.println("3: " + pets.contains(9));
		pets.remove(String.valueOf(9));// Remove by object
		System.out.println("3: " + pets);
		String p = pets.get(2);
		System.out.println("4: " + p + " " + pets.indexOf(p));
		String cymric = new String("1");
		System.out.println("5: " + pets.indexOf(cymric));
		System.out.println("6: " + pets.remove(cymric));
		System.out.println("6: " + pets);
		// // Must be the exact object:
		System.out.println("7: " + pets.remove(p));
		System.out.println("8: " + pets);
		pets.add(3, new String("111")); // Insert at an index
		System.out.println("9: " + pets);
		List<String> sub = pets.subList(1, 4);
		System.out.println("subList: " + sub);
		System.out.println("10: " + pets.containsAll(sub));
		Collections.sort(sub); // In-place sort
		System.out.println("sorted subList: " + sub);
		// // Order is not important in containsAll():
		System.out.println("11: " + pets.containsAll(sub));
		Collections.shuffle(sub, rand); // Mix it up
		System.out.println("shuffled subList: " + sub);
		System.out.println("12: " + pets.containsAll(sub));
		List<String> copy = new ArrayList<String>(pets); // new
															// 一个新的引用，直接赋值会改变pets的值
		sub = Arrays.asList(pets.get(1), pets.get(4));
		System.out.println("sub: " + sub);
		copy.retainAll(sub);
		System.out.println("13: " + copy);
		copy = new ArrayList<String>(pets); // Get a fresh copy
		copy.remove(2); // Remove by index
		System.out.println("14: " + copy);
		copy.removeAll(sub); // Only removes exact objects
		System.out.println("15: " + copy);
		copy.set(1, "222"); // Replace an element
		System.out.println("16: " + copy);
		copy.addAll(2, sub); // Insert a list in the middle
		System.out.println("17: " + copy);
		System.out.println("18: " + pets.isEmpty());
		pets.clear(); // Remove all elements
		System.out.println("19: " + pets);
		System.out.println("20: " + pets.isEmpty());
		pets.addAll(Arrays.asList("66", "77", "88", "99"));
		System.out.println("21: " + pets);
		Object[] o = pets.toArray();
		System.out.println("22: " + o[3]);
		String[] pa = pets.toArray(new String[10]);
		for (int i = 0; i < pa.length; i++) {
			System.out.println("23: " + pa[i]);
		}

	}
} /*
 * Output: 1: [Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug] 2: [Rat, Manx, Cymric,
 * Mutt, Pug, Cymric, Pug, Hamster] 3: true 4: Cymric 2 5: -1 6: false 7: true
 * 8: [Rat, Manx, Mutt, Pug, Cymric, Pug] 9: [Rat, Manx, Mutt, Mouse, Pug,
 * Cymric, Pug] subList: [Manx, Mutt, Mouse] 10: true sorted subList: [Manx,
 * Mouse, Mutt] 11: true shuffled subList: [Mouse, Manx, Mutt] 12: true sub:
 * [Mouse, Pug] 13: [Mouse, Pug] 14: [Rat, Mouse, Mutt, Pug, Cymric, Pug] 15:
 * [Rat, Mutt, Cymric, Pug] 16: [Rat, Mouse, Cymric, Pug] 17: [Rat, Mouse,
 * Mouse, Pug, Cymric, Pug] 18: false 19: [] 20: true 21: [Manx, Cymric, Rat,
 * EgyptianMau] 22: EgyptianMau 23: 14
 */// :~
