package com.thinking.collection.demo4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Gerbils18 {
	public static void main(String[] args) {
		Map<String, Gerbil> gerbils = new HashMap<String, Gerbil>();
		gerbils.put("Fuzzy", new Gerbil(0));
		gerbils.put("Spot", new Gerbil(1));
		gerbils.put("Speedy", new Gerbil(2));
		gerbils.put("Dopey", new Gerbil(3));
		gerbils.put("Sleepy", new Gerbil(4));
		gerbils.put("Happy", new Gerbil(5));
		gerbils.put("Funny", new Gerbil(6));
		gerbils.put("Silly", new Gerbil(7));
		gerbils.put("Goofy", new Gerbil(8));
		gerbils.put("Wowee", new Gerbil(9));
		System.out.println(gerbils);
		System.out.println();
		
//		Set<String> sortedKeys = 
//			new TreeSet<String>(gerbils.keySet());
		
//		Set<String> sortedKeys = 
//			new HashSet<String>(gerbils.keySet());
		
		Set<String> sortedKeys = 
				new LinkedHashSet<String>(gerbils.keySet());
		
		System.out.println(sortedKeys);
		System.out.println();
		
		Map<String, Gerbil> sortedGerbils = 
			new LinkedHashMap<String, Gerbil>();
		for(String s : sortedKeys) {
			System.out.print("Adding " + s + ", ");
			sortedGerbils.put(s, gerbils.get(s));			
		}
		System.out.println();
		System.out.println();
		System.out.println(sortedGerbils);
		System.out.println();
		// or, just:
		Map<String, Gerbil> sortedGerbils2 =
			new TreeMap<String, Gerbil>(gerbils);
		System.out.println(sortedGerbils2);		
	}
}