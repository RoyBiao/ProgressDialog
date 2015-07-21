package com.design.factory;

public class DivFactory implements IFactory{

	@Override
	public Operation createOperation() {
		// TODO Auto-generated method stub
		return new OperationMul();
	}

}
