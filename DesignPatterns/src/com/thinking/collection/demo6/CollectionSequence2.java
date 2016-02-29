//: holding/CollectionSequence.java
package com.thinking.collection.demo6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.thinking.typeinfo.demo2.Pets;
import com.thinking.typeinfo.demo2.model.Pet;

public class CollectionSequence2 implements Collection<Pet> {
	private List<Pet> pets =new ArrayList<Pet>(Arrays.asList(Pets.createArray(8))) ;

	@Override
	public boolean add(Pet object) {
		return pets.add(object);
	}

	@Override
	public boolean addAll(Collection<? extends Pet> collection) {
		return pets.addAll(collection);
	}

	@Override
	public void clear() {
		pets.clear();
	}

	@Override
	public boolean contains(Object object) {
		return pets.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return pets.containsAll(collection);
	}

	@Override
	public boolean isEmpty() {
		return pets.isEmpty();
	}

	@Override
	public boolean remove(Object object) {
		return pets.remove(object);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return pets.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return pets.retainAll(collection);
	}

	@Override
	public Object[] toArray() {
		return pets.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return pets.toArray(array);
	}

	@Override
	public Iterator<Pet> iterator() {
		return pets.iterator();
	}

	@Override
	public int size() {
		return pets.size();
	}

	public static void main(String[] args) {
		CollectionSequence2 c = new CollectionSequence2();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
	}
} /*
 * Output: 0:Rat 1:Manx 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx 0:Rat 1:Manx
 * 2:Cymric 3:Mutt 4:Pug 5:Cymric 6:Pug 7:Manx
 */// :~
