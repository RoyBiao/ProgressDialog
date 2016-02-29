package com.design.decoration;
/**
 * в╟йндёй╫
 * @author ruibiao
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Person person=new Person("A");
		BigTrouser bigTrouser=new BigTrouser();
		Tshirts tshirts=new Tshirts();
		
		tshirts.Decorate(person);
		bigTrouser.Decorate(tshirts);
		
		bigTrouser.show();
	}

}
