package com.design.proxy;

public class proxy implements GiveGift {
	
	man man;
	
	public proxy(girl girl){
		man=new man(girl);
	}
	@Override
	public void GiveDolls() {
		man.GiveDolls();
	}

	@Override
	public void GiveFlowers() {
		man.GiveFlowers();
	}

	@Override
	public void GiveChocolate() {
		man.GiveChocolate();
	}

}
