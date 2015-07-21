package com.design.proxy;

public class man implements GiveGift {
	girl girl;  
	public man(girl girl){
		this.girl=girl;
	}
	@Override
	public void GiveDolls() {
		System.out.println(girl.getName()+"give your dolls");
	}

	@Override
	public void GiveFlowers() {
		System.out.println(girl.getName()+"give your flowers");
	}

	@Override
	public void GiveChocolate() {
		System.out.println(girl.getName()+"give your chocolate");
	}
}
