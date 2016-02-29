package com.design.prototype;

//原型模式
public class Test {

	public static void main(String[] args) {

		Resume a=new Resume();
		a.setInfo("me","hs");
		
		Resume b=(Resume) a.clone();
		b.setInfo("me","sr");
		
		a.show();
		b.show();
		
	}

}
