package com.unknow.interfaces;

/**
 * �ӿڻص�
 * @author hs
 *
 */
public class Test {

	public static void main(String[] args) {
		
		callee callee=new callee();
		Caller caller=new Caller();
		
		//��Caller����callee�Ļص�����
		caller.setI(callee);
		caller.call();
	}

}
