package com.design.proxy;

/**
 * ����ģʽ
 * @author ruibiao
 *
 */
public class Test {
	public static void main(String[] args) {
		girl girl=new girl();
		girl.setName("jiaojiao");
		
		proxy proxy=new proxy(girl);
		proxy.GiveChocolate();
		proxy.GiveDolls();
		proxy.GiveFlowers();
	}
}
