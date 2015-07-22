package com.unknow.regex;

import java.util.Arrays;
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
		test2.test10();
		
		

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

	private final static String POEM = "Twas brillig, and the slithy toves\n"
			+ "Did gyre and gimble in the wabe.\n"
			+ "All mimsy were the borogoves,\n"
			+ "And the mome raths outgrabe.\n"
			+ "Beware the Jabberwock, my son,\n"
			+ "The jaws that bite, the claws that catch.\n"
			+ "Beware the Jubjub bird ! and shun\n"
			+ "The frumious Bandersnatch.";

	private void test7() {
		Matcher m = Pattern.compile("(^[A-Z]|\\s+[A-Z])\\w+").matcher(POEM);
		Set<String> words = new TreeSet<String>();
		while (m.find()) {
			System.out.println(m.group());
			words.add(m.group());
		}
		// System.out.println("Number of unique non-cap words = " +
		// words.size());
		// System.out.println(words);
	}

	public static String input = "As long as there is injustice, whenever a\n"
			+ "Targathian baby cries out, wherever a distress\n"
			+ "signal sounds among the stars ... We'll be there.\n"
			+ "This fine ship, and this fine crew ...\n"
			+ "Never give up! Never surrender!";

	private static class Display {
		private boolean regexPrinted = false;
		private String regex;

		Display(String regex) {
			this.regex = regex;
		}

		void display(String message) {
			if (!regexPrinted) {
				System.out.println(regex);
				regexPrinted = true;
			}
			System.out.println(message);
		}
	}

	static void examine(String s, String regex) {
		Display d = new Display(regex);
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		while (m.find())
			d.display("find() '" + m.group() + "' start = " + m.start()
					+ " end = " + m.end());
		// if (m.lookingAt()) // No reset() necessary
		// d.display("lookingAt() start = " + m.start() + " end = " + m.end());
		// if (m.matches()) // No reset() necessary
		// d.display("matches() start = " + m.start() + " end = " + m.end());
	}

	private void test8() {
		for (String in : POEM.split("\n")) {
			System.out.println("input : " + in);
			for (String regex : new String[] { "\\w*ere\\w*", "\\w*ever",
					"T.+", "Beware.*?!" })
				examine(in, regex);
		}
	}

	private void test9() {
		String input = "This!unusual use!!!of !exclamation!!points !";

		//String[] inputs = input.split("[^!]*!+[^!]*");

		pattern=Pattern.compile("[^!]*!+[^!]*");
		String[] inputs  = pattern.split(input);
		for (int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i]);
		}

		System.out.println(Arrays.toString(inputs));
	}

	private void test10() {
		String s = "/*! Here's a block of text to use as input to the regular expression matcher. Note that we'll first extract the block of text by looking for the special delimiters, then process the  extracted block. !*/";
		// Match the specially commented block of text above:
		Matcher mInput = Pattern.compile("/\\*!(.*)!\\*/", Pattern.DOTALL)
				.matcher(s);
		if (mInput.find())
			s = mInput.group(1); // Captured by parentheses
		System.out.println(s);
		// Replace two or more spaces with a single space:
		s = s.replaceAll(" {2,}", " ");
		// Replace one or more spaces at the beginning of each
		// line with no spaces. Must enable MULTILINE mode:
		s = s.replaceAll("(?m)^ +", "");
		System.out.println(s);
		s = s.replaceFirst("[aeiou]", "(VOWEL1)");
		System.out.println(s);
		StringBuffer sbuf = new StringBuffer();
		Pattern p = Pattern.compile("[aeiou]");
		Matcher m = p.matcher(s);
		// Process the find information as you
		// perform the replacements:
		while (m.find())
			m.appendReplacement(sbuf, m.group().toUpperCase());
		// Put in the remainder of the text:
		m.appendTail(sbuf);
		System.out.println(sbuf);
	}

}
