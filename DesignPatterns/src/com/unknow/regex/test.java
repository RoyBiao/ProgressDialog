package com.unknow.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class test {

	//Pattern.compile("^[1][3,5]+\\d{9}")
	public static void main(String[] args) {
		//ʮ��λ���֤
		String a="440582199207306651";
		StringBuilder builder =new StringBuilder();
		builder.append(a.substring(0, 6));
		builder.append(a.substring(6, 14).replaceAll("\\d", "*"));
		builder.append(a.substring(14,a.length()));
		System.out.println(builder.toString());
		System.out.println();
		//ʮ��λ���֤
		a ="130503670401001";
		StringBuilder builder2 =new StringBuilder();
		builder2.append(a.substring(0, 6));
		builder2.append(a.substring(6, 12).replaceAll("\\d", "*"));
		builder2.append(a.substring(12,a.length()));
		System.out.println(builder2.toString());
		System.out.println();
		//�ж��Ƿ�Ϊ���֤
		Pattern p = Pattern.compile("^\\d{15}|\\d{18}$"); // ������ʽ
		Matcher m = p.matcher("12010119850602s0080");// �������ַ���
		if( m.matches()){
			System.out.println("�ú���Ϊ���֤");
		}else{
			System.out.println("�ú��벻�����֤");
		}
	}
}
