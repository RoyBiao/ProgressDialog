//: typeinfo/pets/ForNameCreator.java
package com.thinking.typeinfo.demo2.creator;

import java.util.*;

import com.thinking.typeinfo.demo2.model.Pet;

public class ForNameCreator extends PetCreator {
	private static List<Class<? extends Pet>> types = new ArrayList<Class<? extends Pet>>();
	// Types that you want to be randomly created:
	private static String[] typeNames = { "com.thinking.typeinfo.demo2.model.Mutt",
			"com.thinking.typeinfo.demo2.model.Pug", "com.thinking.typeinfo.demo2.model.EgyptianMau",
			"com.thinking.typeinfo.demo2.model.Manx", "com.thinking.typeinfo.demo2.model.Cymric", "com.thinking.typeinfo.demo2.model.Rat",
			"com.thinking.typeinfo.demo2.model.Mouse", "com.thinking.typeinfo.demo2.model.Hamster" };

	@SuppressWarnings("unchecked")
	private static void loader() {
		try {
			for (String name : typeNames)
				types.add((Class<? extends Pet>) Class.forName(name));
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	static {
		loader();
	}

	public List<Class<? extends Pet>> types() {
		return types;
	}
} // /:~
