package com.unknow.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
���õķ��� 
. ��ʾ����һ���ַ�
\s �ո��ַ�(�ո��, tab, ����, ��ҳ, �س�) 
\S �ǿո��ַ�([^\s])
\d һ�����֣����൱��[0-9]  ��
\D  һ�������ֵ��ַ������൱��[^0-9] ��
\w һ�������ַ�(word character) ���൱�� [a-zA-Z_0-9] ��
\W һ���ǵ��ʵ��ַ���[^\w]
^ һ�еĿ�ʼ
$ һ�еĽ�β
\b һ�����ʵı߽� 
\B һ���ǵ��ʵı߽�
\G ǰһ��ƥ��Ľ���
[] ƥ�䷽�����ڵ�һ���ַ�  ���磺[abc] ��ʾ�ַ�a��b��c�е�����һ��(��a|b|c��ͬ)
[a-zA-Z] ��ʾ��a��z��A��Z���е�����һ���ַ�
��ʾ�����ķ��� 
* �ظ���λ�����  ���磺a* ƥ��������߶��a
+ �ظ�һ�λ��������磺a+ ƥ��һ�����߶��a
? �ظ���λ�һ�� ���磺a? ƥ�������һ��a
{n} �ظ�n��  ���磺a{4} ƥ��4��a
{n,} �ظ�n�λ�����  ���磺a{4,} ƥ������4��a
{n,m} �ظ�n��m�� ���磺a{4,10} ƥ��4~10��a
*/
public class MatcherTest {

	public static void main(String[] args) {
		MatcherTest test=new MatcherTest();
		test.test7();
	}
	
	public void test1() {
		Pattern p = null; // ������ʽ
		Matcher m = null; // �������ַ���
		boolean b = false;
		// ������ʽ��ʾ����ĸ��a���м�����������a����β��b����
		// ��ƥ��Ľ��
		p = Pattern.compile("a*b");
		m = p.matcher("baaaaab");
		b = m.matches();
		System.out.println("ƥ������" + b); // �����false
		// ƥ��Ľ��
		p = Pattern.compile("a*b");
		m = p.matcher("aaaaab");
		b = m.matches();
		System.out.println("ƥ������" + b); // �����true
	}

	/**
	 * �ֻ�����
	 */
	public void test2() {
		Pattern p = null; // ������ʽ
		Matcher m = null; // �������ַ���
		boolean b = false;
		// ������ʽ��ʾ��һλ��1���ڶ�λΪ3��5����βΪ9λ���ֵ�һ������
		p = Pattern.compile("^[1][3,5]+\\d{9}");
		m = p.matcher("13812345678");
		b = m.matches();
		System.out.println("�ֻ�������ȷ��" + b); // �����true
		//
		p = Pattern.compile("[1][3,5]+\\d{9}");
		m = p.matcher("13812345678");// ���� ��λΪ0
		// m = p.matcher("13812345-7a");//���� �ַ���������ĸ�����ַ�
		b = m.matches();
		System.out.println("�ֻ��������" + b); // �����false
	}

	/**
	 * ���֤
	 */
	public void test3() {
		Pattern p = null; // ������ʽ
		Matcher m = null; // �������ַ���
		boolean b = false;
		// ������ʽ��ʾ15λ����18λ���ֵ�һ������
		p = Pattern.compile("^\\d{15}|\\d{18}$");
		m = p.matcher("120101198506020080");
		b = m.matches();
		System.out.println("���֤������ȷ��" + b); // �����true
		//
		p = Pattern.compile("^\\d{15}|\\d{18}$");
		m = p.matcher("020101198506020080");// ���� ��λΪ0
		b = m.matches();
		System.out.println("���֤�������" + b); // �����false
		
//		Pattern pattern =Pattern.compile("");
//		Matcher matcher = pattern.matcher("");
//		matcher.matches();
	}

	/**
	 * ����
	 */
	public void test4() {
		Pattern p = null; // ������ʽ
		Matcher m = null; // �������ַ���
		boolean b = false;
		// ������ʽ��ʾ�������
		p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		m = p.matcher("user@test.com");
		b = m.matches();
		System.out.println("email������ȷ��" + b); // �����true
		//
		p = Pattern
				.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		m = p.matcher("user.test.com");// ���� @ӦΪ.
		b = m.matches();
		System.out.println("email�������" + b); // �����false
	}

	/**
	 * ip
	 */
	public void test5() {
		Pattern p = null; // ������ʽ
		Matcher m = null; // �������ַ���
		boolean b = false;
		// ������ʽ��ʾ�������
		p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		m = p.matcher("1.1.1.1");
		b = m.matches();
		System.out.println("IP��ȷ��" + b); // �����true
		//
		p = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}");
		m = p.matcher("192.168.1.124");// ���� Ӧ��Ϊ3λ��Ӧ����4λ
		b = m.matches();
		System.out.println("IP����" + b); // �����false
	}

	/**
	 * 
	 * start()����ƥ�䵽�����ַ������ַ����е�����λ��.
	 * 
	 * end()����ƥ�䵽�����ַ��������һ���ַ����ַ����е�����λ��.
	 * 
	 * group()����ƥ�䵽�����ַ���
	 */
	public void test6() {
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher("aaa2223bb11222");
		System.out.println("test6:"+m.matches());
		while (m.find()) {
			System.out.print(m.start()+"\t");// ��һ��ѭ������3���ڶ���ѭ������9
			System.out.print(m.end()+"\t");// ����7,�ڶ���ѭ������14
			System.out.println(m.group());// ����2233���ڶ�������11222
		}
	}

	/**
	 * groupCount��group()��group(n)���÷�
	 */
	public void test7() {
		/*
		 * ����groupCount����������a11bbb��11��bbb
		 */
		Pattern p = Pattern.compile("(\\w)(\\d\\d)(\\w+)");
		Matcher m = p.matcher("aa11bbb");
		if (m.find()) {
			//System.out.println("group:" + m.group());
			int count = m.groupCount(); // ����ƥ�������Ŀ��������ƥ���ַ�������Ŀ
			for (int i = 0; i <= count; i++)
				System.out.println("group " + i + " :" + m.group(i));
		}
	}

	/**
	 * split
	 */
	public void test8() {
		Pattern p = Pattern.compile("\\d+"); // ����������ȥ��
		String str[] = p.split("aa11bbb33cc55gg");
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
	}

	public void test9() {
		Pattern p = Pattern.compile("\\d+"); // ����������ȫ���滻ΪXX
		Matcher m = p.matcher("aa11bbb33cc55gg");
		if (m.find()) {
			System.out.println( m.group());
			int count = m.groupCount(); // ����ƥ�������Ŀ��������ƥ���ַ�������Ŀ
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
			m.appendReplacement(sb, "@@");// ��@@�滻���е�55
		}
		System.out.println(sb.toString());// ��ӡaa11bbb33cc@@gg@@
		m.appendTail(sb);// �����һ���滻����ַ�������
		System.out.println(sb.toString());// ��ӡaa11bbb33cc@@gg@@yy
	}
}