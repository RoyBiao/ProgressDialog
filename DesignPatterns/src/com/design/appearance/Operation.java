package com.design.appearance;

public class Operation implements BuyInterface{

	Fund fund;
	
	public Operation (Fund fund){
		this.fund=fund;
	}
	
	@Override
	public void buy() {
		fund.buyFund();
	}

	@Override
	public void sell() {
		fund.sellFund();
	}

}
