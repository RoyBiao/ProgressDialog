package com.design.abstract_factory;

import com.design.abstract_factory.base.People;
import com.design.abstract_factory.factory.CreateFemalePeople;
import com.design.abstract_factory.factory.CreateMalePeople;
import com.design.abstract_factory.factory.Factory;

/**
 * 抽象工厂
 * @author ruibiao
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//第一条生产线，生产女人  
        Factory maleFactory = new CreateMalePeople();  
        //第二条生产线，生产男人  
        Factory famaleFactory = new CreateFemalePeople();  
          
        //开始造人--男人  
        People yellowMalePeople = maleFactory.createYellow();  
        yellowMalePeople.sex();  
        People blackMalePeople = maleFactory.createBlack();  
        blackMalePeople.sex();  
        People whiteMalePeople = maleFactory.createWhite();  
        whiteMalePeople.sex();  
        //开始造人--女人  
        People yellowFamalelePeople = famaleFactory.createYellow();  
        yellowFamalelePeople.sex();  
        People blackFamalePeople = famaleFactory.createBlack();  
        blackFamalePeople.sex();  
        People whiteFamalePeople = famaleFactory.createWhite();  
        whiteFamalePeople.sex();  
	}

}
