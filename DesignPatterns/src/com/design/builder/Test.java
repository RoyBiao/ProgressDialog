package com.design.builder;

/**
 * НЈдьеп
 * @author ruibiao
 *
 */
public class Test {

	public static void main(String[] args) {
		Person thinPerson=new ThinPerson();
		PersonDirector director=new PersonDirector(thinPerson);
		director.createPerson();
		System.out.println("--------------------------");
		Person fatPerson=new FatPerson();
		PersonDirector director2=new PersonDirector(fatPerson);
		director.createPerson();
	}
	
}
