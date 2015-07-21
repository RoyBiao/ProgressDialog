package com.design.abstract_factory.entity;

import com.design.abstract_factory.base.AbstractBlackPeople;

public class WhiteMalePeople extends AbstractBlackPeople {

	@Override
	public void sex() {
		System.out.println("该白种人性别为男");  
	}

}
