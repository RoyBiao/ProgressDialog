package com.unknow.regex;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("unused")
public class MatcherTest2 {
	private Pattern pattern = null;
	private Matcher matcher = null;
	public static String knights = "Then, when you have found the shrubbery, you must "
			+ "cut down the mightiest tree in the forest... "
			+ "with... a herring!";

	public static void main(String[] args) {
		MatcherTest2 test2 = new MatcherTest2();
		test2.test7();

	}

	/**
	 * 首字母大写以句号结尾
	 */
	private void test1() {
		pattern = Pattern.compile("^[A-Z]+.*。$");
		matcher = pattern
				.matcher("A阿苏撒旦阿苏打算打asds算打算打算打算打算打asdasd算大撒阿苏如同有人天涯如同犹太人。");
		System.out.println("matcher:" + matcher.matches());
	}

	/**
	 * 
	 */
	private void test2() {
		// System.out.println(Arrays.toString(knights.split("the|you")));
		pattern = Pattern.compile("the|you");
		matcher = pattern.matcher(knights);
		while (matcher.find()) {
			for (int i = 0; i < matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}

	/**
	 * 将所有元音替换为下划线
	 */
	private void test3() {
		knights = knights.replaceAll("a|e|i|o|u|A|E|I|O|U", "_");
		System.out.println("knights:" + knights);
	}

	/**
	 * 取出头尾都是元音字母的单词 (?i) 忽略大小写
	 */
	private void test4() {
		Pattern p = Pattern
				.compile("(?i)((^[aeiou])|(\\s+[aeiou]))\\w+[aeiou]\\b");
		Matcher m = p
				.matcher("Arline ate eight apples and one orange while Anita hadn't any");
		while (m.find())
			System.out.println("Match \"" + m.group() + "\" at " + m.start());
	}

	private void test5() {
		pattern = Pattern.compile("\\w+");
		matcher = pattern.matcher("Evening is full of the linnet's wings");
		while (matcher.find()) {
			System.out.println("find matcher.group():" + matcher.group());
		}
		int i = 0;
		while (matcher.find(i)) {
			System.out.println("find(i) matcher.group():" + matcher.group());
			i++;
		}
	}

	/**
	 * 
	 * (?m) 打开多行模式
	 */
	private void test6() {
		String POEM = "Twas brillig, and the slithy toves\n"
				+ "Did gyre and gimble in the wabe.\n"
				+ "All mimsy were the borogoves,\n"
				+ "And the mome raths outgrabe.\n\n"
				+ "Beware the Jabberwock, my son,\n"
				+ "The jaws that bite, the claws that catch.\n"
				+ "Beware the Jubjub bird, and shun\n"
				+ "The frumious Bandersnatch.";

		Matcher m = Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$")
				.matcher(POEM);

		while (m.find()) {
			for (int j = 0; j <= m.groupCount(); j++)
				System.out.print("[" + m.group(j) + "]");
			System.out.println();
		}
	}
	
	private void test7(){
		String POEM = "Twas brillig, and the slithy toves\n"
				+ "Did gyre and gimble in the wabe.\n"
				+ "All mimsy were the borogoves,\n"
				+ "And the mome raths outgrabe.\n\n"
				+ "Beware the Jabberwock, my son,\n"
				+ "The jaws that bite, the claws that catch.\n"
				+ "Beware the Jubjub bird, and shun\n"
				+ "The frumious Bandersnatch.";
		
		Matcher m = Pattern.compile("(^[A-Z]|\\s+[A-Z])\\w+").matcher(POEM);
		Set<String> words = new TreeSet<String>();
		while(m.find()) {
			words.add(m.group());
		}
		System.out.println("Number of unique non-cap words = " + words.size());
		System.out.println(words);
		
	}
}
