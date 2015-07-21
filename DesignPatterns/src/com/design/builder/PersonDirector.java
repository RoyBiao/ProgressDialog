package com.design.builder;

public class PersonDirector {

	private Person person;
	public PersonDirector(Person person){
		this.person=person;
	}
	public void createPerson(){
		person.buildHead();
		person.buildBody();
		person.buildArmLeft();
		person.buildArmRight();
		person.buildLegLeft();
		person.buildLegRight();
	}
}
