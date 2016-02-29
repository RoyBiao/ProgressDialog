//: typeinfo/pets/LiteralPetCreator.java
// Using class literals.
package com.thinking.typeinfo.demo2.creator;

import java.util.*;

import com.thinking.typeinfo.demo2.model.Cat;
import com.thinking.typeinfo.demo2.model.Cymric;
import com.thinking.typeinfo.demo2.model.Dog;
import com.thinking.typeinfo.demo2.model.EgyptianMau;
import com.thinking.typeinfo.demo2.model.Gerbil;
import com.thinking.typeinfo.demo2.model.Hamster;
import com.thinking.typeinfo.demo2.model.Manx;
import com.thinking.typeinfo.demo2.model.Mouse;
import com.thinking.typeinfo.demo2.model.Mutt;
import com.thinking.typeinfo.demo2.model.Pet;
import com.thinking.typeinfo.demo2.model.Pug;
import com.thinking.typeinfo.demo2.model.Rat;
import com.thinking.typeinfo.demo2.model.Rodent;

public class LiteralPetCreator extends PetCreator {
	// No try block needed.
	@SuppressWarnings("unchecked")
	public static final List<Class<? extends Pet>> allTypes = Collections
			.unmodifiableList(Arrays.asList(Pet.class, Dog.class, Cat.class,
					Rodent.class, Mutt.class, Pug.class, EgyptianMau.class,
					Manx.class, Cymric.class, Rat.class, Mouse.class,
					Hamster.class,Gerbil.class));
	// Types for random creation:
	private static final List<Class<? extends Pet>> types = allTypes.subList(
			allTypes.indexOf(Mutt.class), allTypes.size());

	public List<Class<? extends Pet>> types() {
		return types;
	}

	public static void main(String[] args) {
		System.out.println(types);
	}
} /*
 * Output: [classcom.thinking.typeinfo.demo2.Mutt,
 * classcom.thinking.typeinfo.demo2.Pug,
 * classcom.thinking.typeinfo.demo2.EgyptianMau,
 * classcom.thinking.typeinfo.demo2.Manx,
 * classcom.thinking.typeinfo.demo2.Cymric,
 * classcom.thinking.typeinfo.demo2.Rat, classcom.thinking.typeinfo.demo2.Mouse,
 * classcom.thinking.typeinfo.demo2.Hamster]
 */// :~
