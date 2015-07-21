package com.design.factory;

public class MulFactory implements IFactory{

	@Override
	public Operation createOperation() {
		// TODO Auto-generated method stub
		return new OperationDiv();
	}

}
