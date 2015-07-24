package com.unknow.regex;

public class MatcherTest3 {

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

	private static void test1() {
		String test = "a<tr>aava </tr>abb ";
		String reg = "<.+>";
		System.out.print("̰���ͣ�");
		System.out.println(test.replaceAll(reg, "###"));
	}

	private static void test2() {
		String test = "a<tr>aava </tr>abb ";
		String reg = "<.+?>";
		System.out.print("��ǿ�ͣ�");
		System.out.println(test.replaceAll(reg, "###"));
	}

	private static void test3() {
		String test = "a<tr>aava </tr>abb ";
		String test2 = "<tr>";
		String reg = "<.++>";
		String reg2 = "<tr>";
		System.out.print("ռ���ͣ�");
		System.out.println(test.replaceAll(reg, "###"));
		System.out.print("ռ���ͣ�");
		System.out.println(test2.replaceAll(reg2, "###"));
	}
}
