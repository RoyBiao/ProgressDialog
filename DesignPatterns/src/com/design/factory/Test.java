package com.design.factory;

public class Test {
	public static void main(String[] args) {
//		IFactory factory=new DivFactory();
//		Operation operation=factory.createOperation();
//		operation.setNumberA(3.2);
//		operation.setNumberB(3.2);
//		double result=operation.getResult();
//		System.out.println(result);
		
		Operation ope=OperationFactoty.createOperation("*");
		ope.setNumberA(3.2);
		ope.setNumberB(3.2);
		System.out.println(ope.getResult());
		
		
	}
}
