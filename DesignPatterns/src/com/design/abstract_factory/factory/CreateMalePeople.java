package com.design.abstract_factory.factory;

import com.design.abstract_factory.base.People;
import com.design.abstract_factory.entity.BlackMalePeople;
import com.design.abstract_factory.entity.WhiteMalePeople;
import com.design.abstract_factory.entity.YellowMalePeople;

public class CreateMalePeople extends AbstractFactory{

	public People createYellow() {  
        return super.createPeople(YellowMalePeople.class);  
    }  
  
    public People createWhite() {  
        return super.createPeople(WhiteMalePeople.class);  
    }  
  
    public People createBlack() {  
        return super.createPeople(BlackMalePeople.class);  
    }  

}
