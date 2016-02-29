package com.design.abstract_factory;

import com.design.abstract_factory.base.People;
import com.design.abstract_factory.factory.CreateFemalePeople;
import com.design.abstract_factory.factory.CreateMalePeople;
import com.design.abstract_factory.factory.Factory;

/**
 * ���󹤳�
 * @author ruibiao
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//��һ�������ߣ�����Ů��  
        Factory maleFactory = new CreateMalePeople();  
        //�ڶ��������ߣ���������  
        Factory famaleFactory = new CreateFemalePeople();  
          
        //��ʼ����--����  
        People yellowMalePeople = maleFactory.createYellow();  
        yellowMalePeople.sex();  
        People blackMalePeople = maleFactory.createBlack();  
        blackMalePeople.sex();  
        People whiteMalePeople = maleFactory.createWhite();  
        whiteMalePeople.sex();  
        //��ʼ����--Ů��  
        People yellowFamalelePeople = famaleFactory.createYellow();  
        yellowFamalelePeople.sex();  
        People blackFamalePeople = famaleFactory.createBlack();  
        blackFamalePeople.sex();  
        People whiteFamalePeople = famaleFactory.createWhite();  
        whiteFamalePeople.sex();  
	}

}
