//: typeinfo/PetCount.java
// Using instanceof.
package com.thinking.typeinfo.demo2;

import java.util.*;

import com.thinking.typeinfo.demo2.creator.LiteralPetCreator;
import com.thinking.typeinfo.demo2.creator.PetCreator;
import com.thinking.typeinfo.demo2.model.Cat;
import com.thinking.typeinfo.demo2.model.Dog;
import com.thinking.typeinfo.demo2.model.Hamster;
import com.thinking.typeinfo.demo2.model.Manx;
import com.thinking.typeinfo.demo2.model.Mouse;
import com.thinking.typeinfo.demo2.model.Mutt;
import com.thinking.typeinfo.demo2.model.Pet;
import com.thinking.typeinfo.demo2.model.Pug;
import com.thinking.typeinfo.demo2.model.Rat;
import com.thinking.typeinfo.demo2.model.Rodent;

public class PetCount {
	static class PetCounter extends HashMap<String, Integer> {
		public void count(String type) {
			Integer quantity = get(type);
			if (quantity == null)
				put(type, 1);
			else
				put(type, quantity + 1);
		}
	}

	public static void countPets(PetCreator creator) {
		PetCounter counter = new PetCounter();
		for (Pet pet : creator.createArray(20)) {
			// List each individual pet:
			System.out.print(pet.getClass().getSimpleName() + " ");
			if (pet instanceof Pet)
				counter.count("Pet");
			if (pet instanceof Dog)
				counter.count("Dog");
			if (pet instanceof Mutt)
				counter.count("Mutt");
			if (pet instanceof Pug)
				counter.count("Pug");
			if (pet instanceof Cat)
				counter.count("Cat");
			if (pet instanceof Manx)
				counter.count("EgyptianMau");
			if (pet instanceof Manx)
				counter.count("Manx");
			if (pet instanceof Manx)
				counter.count("Cymric");
			if (pet instanceof Rodent)
				counter.count("Rodent");
			if (pet instanceof Rat)
				counter.count("Rat");
			if (pet instanceof Mouse)
				counter.count("Mouse");
			if (pet instanceof Hamster)
				counter.count("Hamster");
		}
		// Show the counts:
		System.out.println();
		System.out.println(counter);
	}

	public static void main(String[] args) {
		countPets(new LiteralPetCreator());
	}
} /*
 * Output: Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat EgyptianMau
 * Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric {Pug=3, Cat=9,
 * Hamster=1, Cymric=7, Mouse=2, Mutt=3, Rodent=5, Pet=20, Manx=7,
 * EgyptianMau=7, Dog=6, Rat=2}
 */// :~