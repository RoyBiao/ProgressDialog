package com.design.factory;

public class OperationFactoty {

	public static Operation createOperation(String ope){
		Operation operation=null;
		switch (ope) {
		case "*":
			operation=new OperationMul();
			break;
		case "/":
			operation=new OperationDiv();
			break;
		}
		return operation;
	}
}
