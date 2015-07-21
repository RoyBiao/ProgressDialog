package com.design.abstract_factory.factory;

import com.design.abstract_factory.base.People;
import com.design.abstract_factory.entity.BlackFamalePeople;
import com.design.abstract_factory.entity.WhiteFamalePeople;
import com.design.abstract_factory.entity.YellowFamalePeople;

public class CreateFemalePeople extends AbstractFactory{

	public People createYellow() {  
        return super.createPeople(YellowFamalePeople.class);  
    }  
  
    public People createWhite() {  
        return super.createPeople(WhiteFamalePeople.class);  
    }  
  
    public People createBlack() {  
        return super.createPeople(BlackFamalePeople.class);  
    } 

}
