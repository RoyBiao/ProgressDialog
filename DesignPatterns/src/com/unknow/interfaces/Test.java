package com.unknow.interfaces;

/**
 * 接口回调
 * @author hs
 *
 */
public class Test {

	public static void main(String[] args) {
		
		callee callee=new callee();
		Caller caller=new Caller();
		
		//让Caller调用callee的回调方法
		caller.setI(callee);
		caller.call();
	}

}
