package com.thinking.collection.demo4;

import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vowels19 {
	static void vowelCounter(Set<String> st) {
		Set<Character> vowels = new TreeSet<Character>();
		Collections.addAll(vowels, 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o',
				'u');
		int allVowels = 0;
		for (String s : st) {
			int count = 0;
			for (Character v : s.toCharArray()) {
				if (vowels.contains(v)) {
					count++;
					allVowels++;
				}
			}
			System.out.print(s + ": " + count + ", ");
		}
		System.out.println();
		System.out.print("Total vowels: " + allVowels);
	}
	
	static void vowelCounter2(Set<String> st) {
		Pattern pattern = Pattern.compile("(?i)[aeiou]{1}");
		Map<String, Integer> map =new TreeMap<String, Integer>();
		Iterator<String> iterator =st.iterator();
		while(iterator.hasNext()){
			String str=iterator.next();
			System.out.println(str);
			Matcher matcher = pattern.matcher(str);
			int i=0;
			while(matcher.find()){
				System.out.println(matcher.group());
				map.put(str,++i);
				for(int j=0;j<matcher.groupCount();j++){
					System.out.println(matcher.group(i));
				}
			}
		}
		for(String str:map.keySet()){
			System.out.print(str+":"+map.get(str)+" ");
		}
	}

	public static void main(String[] args) {
		String str = "Create a Set of the vowels. Working from UniqueWords.java, count and display the number of vowels in each input word, and also display the total number of vowels in the input file.";
		// String[] arr = str.split("\\w+");
		Pattern pattern = Pattern.compile("\\w+");
		Matcher matcher = pattern.matcher(str);
		Set<String> words = new TreeSet<String>();
		while(matcher.find()) {
			//System.out.println(matcher.group());
			words.add(matcher.group());
		}
		vowelCounter2(words);
	}
}
