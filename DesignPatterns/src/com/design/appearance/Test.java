package com.design.appearance;

/**
 * 外观模式
 * @author ruibiao
 *
 */
public class Test {

	public static void main(String[] args) {
		Fund fund=new Fund();
		Operation operation=new Operation(fund);
		operation.buy();
		operation.sell();
	}
}
