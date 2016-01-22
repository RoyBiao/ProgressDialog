package com.unknow.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
常用的符号 
. 表示任意一个字符
\s 空格字符(空格键, tab, 换行, 换页, 回车) 
\S 非空格字符([^\s])
\d 一个数字，（相当于[0-9]  ）
\D  一个非数字的字符，（相当于[^0-9] ）
\w 一个单词字符(word character) （相当于 [a-zA-Z_0-9] ）
\W 一个非单词的字符，[^\w]
^ 一行的开始
$ 一行的结尾
\b 一个单词的边界 
\B 一个非单词的边界
\G 前一个匹配的结束
[] 匹配方括号内的一个字符  例如：[abc] 表示字符a，b，c中的任意一个(与a|b|c相同)
[a-zA-Z] 表示从a到z或A到Z当中的任意一个字符
表示次数的符号 
* 重复零次或更多次  例如：a* 匹配零个或者多个a
+ 重复一次或更多次例如：a+ 匹配一个或者多个a
? 重复零次或一次 例如：a? 匹配零个或一个a
{n} 重复n次  例如：a{4} 匹配4个a
{n,} 重复n次或更多次  例如：a{4,} 匹配至少4个a
{n,m} 重复n到m次 例如：a{4,10} 匹配4~10个a
*/
public class MatcherTest {

	public static void main(String[] args) {
		MatcherTest test=new MatcherTest();
		test.test7();
	}
	
	public void test1() {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		boolean b = false;
		// 正则表达式表示首字母是a，中间是任意数量a，结尾以b结束
		// 不匹配的结果
		p = Pattern.compile("a*b");
		m = p.matcher("baaaaab");
		b = m.matches();
		System.out.println("匹配结果：" + b); // 输出：false
		// 匹配的结果
		p = Pattern.compile("a*b");
		m = p.matcher("aaaaab");
		b = m.matches();
		System.out.println("匹配结果：" + b); // 输出：true
	}

	/**
	 * 手机号码
	 */
	public void test2() {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		boolean b = false;
		// 正则表达式表示第一位是1，第二位为3或5，结尾为9位数字的一串数字
		p = Pattern.compile("^[1][3,5]+\\d{9}");
		m = p.matcher("13812345678");
		b = m.matches();
		System.out.println("手机号码正确：" + b); // 输出：true
		//
		p = Pattern.compile("[1][3,5]+\\d{9}");
		m = p.matcher("13812345678");// 错误 首位为0
		// m = p.matcher("13812345-7a");//错误 字符串中有字母或者字符
		b = m.matches();
		System.out.println("手机号码错误：" + b); // 输出：false
	}

	/**
	 * 身份证
	 */
	public void test3() {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		boolean b = false;
		// 正则表达式表示15位或者18位数字的一串数字
		p = Pattern.compile("^\\d{15}|\\d{18}$");
		m = p.matcher("120101198506020080");
		b = m.matches();
		System.out.println("身份证号码正确：" + b); // 输出：true
		//
		p = Pattern.compile("^\\d{15}|\\d{18}$");
		m = p.matcher("020101198506020080");// 错误 首位为0
		b = m.matches();
		System.out.println("身份证号码错误：" + b); // 输出：false
		
//		Pattern pattern =Pattern.compile("");
//		Matcher matcher = pattern.matcher("");
//		matcher.matches();
	}

	/**
	 * 邮箱
	 */
	public void test4() {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		boolean b = false;
		// 正则表达式表示邮箱号码
		p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		m = p.matcher("user@test.com");
		b = m.matches();
		System.out.println("email号码正确：" + b); // 输出：true
		//
		p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		m = p.matcher("user.test.com");// 错误 @应为.
		b = m.matches();
		System.out.println("email号码错误：" + b); // 输出：false
	}

	/**
	 * ip
	 */
	public void test5() {
		Pattern p = null; // 正则表达式
		Matcher m = null; // 操作的字符串
		boolean b = false;
		// 正则表达式表示邮箱号码
		p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		m = p.matcher("1.1.1.1");
		b = m.matches();
		System.out.println("IP正确：" + b); // 输出：true
		//
		p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		m = p.matcher("192.168.1.124");// 错误 应该为3位不应该是4位
		b = m.matches();
		System.out.println("IP错误：" + b); // 输出：false
	}

	/**
	 * 
	 * start()返回匹配到的子字符串在字符串中的索引位置.
	 * 
	 * end()返回匹配到的子字符串的最后一个字符在字符串中的索引位置.
	 * 
	 * group()返回匹配到的子字符串
	 */
	public void test6() {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("aaa2223bb11222");
		System.out.println("test6:"+m.matches());
		while (m.find()) {
			System.out.print(m.start()+"\t");// 第一个循环返回3，第二个循环返回9
			System.out.print(m.end()+"\t");// 返回7,第二个循环返回14
			System.out.println(m.group());// 返回2233，第二个返回11222
		}
	}

	/**
	 * groupCount、group()、group(n)的用法
	 */
	public void test7() {
		/*
		 * 本例groupCount将返回三组a11bbb、11、bbb
		 */
		Pattern p = Pattern.compile("(\\w)(\\d\\d)(\\w+)");
		Matcher m = p.matcher("aa11bbb");
		if (m.find()) {
			//System.out.println("group:" + m.group());
			int count = m.groupCount(); // 返回匹配组的数目，而不是匹配字符串的数目
			for (int i = 0; i <= count; i++)
				System.out.println("group " + i + " :" + m.group(i));
		}
	}

	/**
	 * split
	 */
	public void test8() {
		Pattern p = Pattern.compile("\\d+"); // 将所含数字去掉
		String str[] = p.split("aa11bbb33cc55gg");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	public void test9() {
		Pattern p = Pattern.compile("\\d+"); // 将所含数字全部替换为XX
		Matcher m = p.matcher("aa11bbb33cc55gg");
		if (m.find()) {
			System.out.println( m.group());
			int count = m.groupCount(); // 返回匹配组的数目，而不是匹配字符串的数目
			for (int i = 0; i <= count; i++)
				System.out.println("group " + i + " :" + m.group(i));
		}
		String str = m.replaceAll("XX");
		System.out.println(str);
	}

	/**
	 * appendReplacement()
	 */
	public void test10() {
		Pattern p = Pattern.compile("55");
		Matcher m = p.matcher("aa11bbb33cc55gg55yy");
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "@@");// 用@@替换所有的55
		}
		System.out.println(sb.toString());// 打印aa11bbb33cc@@gg@@
		m.appendTail(sb);// 将最后一次替换后的字符串加上
		System.out.println(sb.toString());// 打印aa11bbb33cc@@gg@@yy
	}
}