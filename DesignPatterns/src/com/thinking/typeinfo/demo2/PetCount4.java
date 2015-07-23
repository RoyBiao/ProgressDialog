//: typeinfo/PetCount4.java
package com.thinking.typeinfo.demo2;

import com.thinking.typeinfo.demo2.model.Pet;

/**
 * µÝ¹é¼ÆÊý
 * @author ruibiao
 *
 */
public class PetCount4 {
	public static void main(String[] args) {
		TypeCounter counter = new TypeCounter(Pet.class);
		for (Pet pet : Pets.createArray(20)) {
			System.out.print(pet.getClass().getSimpleName() + " ");
			counter.count(pet);
		}
		System.out.println();
		System.out.print(counter);
	}
} /*
 * Output: (Sample) Rat Manx Cymric Mutt Pug Cymric Pug Manx Cymric Rat
 * EgyptianMau Hamster EgyptianMau Mutt Mutt Cymric Mouse Pug Mouse Cymric
 * {Mouse=2, Dog=6, Manx=7, EgyptianMau=2, Rodent=5, Pug=3, Mutt=3, Cymric=5,
 * Cat=9, Hamster=1, Pet=20, Rat=2}
 */// :~
