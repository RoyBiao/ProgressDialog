//: holding/NonCollectionSequence.java
package com.thinking.collection.demo7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import com.thinking.collection.demo6.InterfaceVsIterator;
import com.thinking.typeinfo.demo2.Pets;
import com.thinking.typeinfo.demo2.model.Pet;

class PetSequence {
	protected Pet[] pets = Pets.createArray(8);
}

public class NonCollectionSequence extends PetSequence implements Iterable<Pet> {
	public Iterator<Pet> iterator() {
		return new Iterator<Pet>() {
			private int index = 0;

			public boolean hasNext() {
				return index < pets.length;
			}

			public Pet next() {
				return pets[index++];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public Iterator<Pet> reversed() {
		return new Iterator<Pet>() {
			private int index = pets.length - 1;

			public boolean hasNext() {
				return index > -1;
			}

			public Pet next() {
				return pets[index--];
			}

			public void remove() { // Not implemented
				throw new UnsupportedOperationException();
			}
		};
	}

	public Iterator<Pet> randomized() {
		List<Pet> shuffled = new ArrayList<Pet>(Arrays.asList(pets));
		Collections.shuffle(shuffled, new Random(47));
		return shuffled.iterator();

	}

	public static void main(String[] args) {
		NonCollectionSequence sequence = new NonCollectionSequence();
		Iterator<Pet> iterator = sequence.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next()+" ");
		}
		System.out.println();
		Iterator<Pet> iterator2 = sequence.randomized();
		while(iterator2.hasNext()){
			System.out.print(iterator2.next()+" ");
		}
		System.out.println();
		Iterator<Pet> iterator3 = sequence.reversed();
		while(iterator3.hasNext()){
			System.out.print(iterator3.next()+" ");
		}
	}
} /*
 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */// :~
