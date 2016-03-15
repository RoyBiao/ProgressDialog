//: holding/CollectionSequence.java
package com.thinking.collection.demo6;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.thinking.typeinfo.demo2.Pets;
import com.thinking.typeinfo.demo2.model.Pet;

public class CollectionSequence extends AbstractCollection<Pet> {
	private Pet[] pets = Pets.createArray(8);

	public int size() {
		return pets.length;
	}

	public static void main(String[] args) {
		CollectionSequence c = new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
	}

	@Override
	public Stream<Pet> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeIf(Predicate<? super Pet> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Spliterator<Pet> spliterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream<Pet> stream() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void forEach(Consumer<? super Pet> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
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
} /*
 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 0:Rat 1:Manx
 * 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */// :~
