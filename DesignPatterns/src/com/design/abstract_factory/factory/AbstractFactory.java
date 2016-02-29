package com.design.abstract_factory.factory;

import com.design.abstract_factory.base.People;

public abstract class AbstractFactory implements Factory{
	
	private People people=null;

	public People createPeople(Class clazz){
		try {
			people = (People) Class.forName(clazz.getName()).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return people;
	}
}
