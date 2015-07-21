package com.unknow.regex;

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
		test2.test1();
		
	}

	/**
	 * ����ĸ��д�Ծ�Ž�β
	 */
	private void test1() {
		pattern = Pattern.compile("^[A-Z]+.*��$");
		matcher = pattern
				.matcher("A�����������մ����asds���������������asdasd�����������ͬ����������ͬ��̫�ˡ�");
		System.out.println("matcher:" + matcher.matches());
	}

	/**
	 * 
	 */
	private void test2() {
		// System.out.println(Arrays.toString(knights.split("the|you")));
		pattern = Pattern.compile("the|you");
		matcher = pattern.matcher(knights);
		if (matcher.find()) {
			for (int i = 0; i < matcher.groupCount(); i++) {
				System.out.println(matcher.group(i));
			}
		}
	}

	/**
	 * ������Ԫ���滻Ϊ�»���
	 */
	private void test3() {
		knights = knights.replaceAll("a|e|i|o|u|A|E|I|O|U", "_");
		System.out.println("knights:" + knights);
	}



}
