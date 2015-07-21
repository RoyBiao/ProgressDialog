package com.design.abstract_factory.entity;

import com.design.abstract_factory.base.AbstractBlackPeople;

public class BlackMalePeople extends AbstractBlackPeople {

	@Override
	public void sex() {
		System.out.println("该黑种人性别为男");  
	}

}
