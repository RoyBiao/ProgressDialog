//: generics/coffee/CoffeeGenerator.java
// Generate different types of Coffee:
package com.thinking.generic.demo03;

import java.util.Iterator;
import java.util.Random;

import com.thinking.generic.coffee.Americano;
import com.thinking.generic.coffee.Breve;
import com.thinking.generic.coffee.Cappuccino;
import com.thinking.generic.coffee.Coffee;
import com.thinking.generic.coffee.Latte;
import com.thinking.generic.coffee.Mocha;
import com.thinking.typeinfo.demo2.Generator;

public class CharatersGenerator implements Generator<StoryCharaters>,
		Iterable<StoryCharaters> {
	private Class[] types = { BadGuy1.class, BadGuy2.class, BadGuy3.class,
			GoodGuy1.class, GoodGuy2.class, GoodGuy3.class };
	private static Random rand = new Random(47);

	public CharatersGenerator() {
	}

	// For iteration:
	private int size = 0;

	public CharatersGenerator(int sz) {
		size = sz;
	}

	public StoryCharaters next() {
		try {
			return (StoryCharaters) types[rand.nextInt(types.length)]
					.newInstance();
			// Report programmer errors at run time:
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	class CharaterIterator implements Iterator<StoryCharaters> {
		int count = size;

		public boolean hasNext() {
			return count > 0;
		}

		public StoryCharaters next() {
			count--;
			return CharatersGenerator.this.next();
		}

		public void remove() { // Not implemented
			throw new UnsupportedOperationException();
		}
	};

	public Iterator<StoryCharaters> iterator() {
		return new CharaterIterator();
	}

	public static void main(String[] args) {
		CharatersGenerator gen = new CharatersGenerator();
		for (int i = 0; i < 5; i++)
			System.out.println(gen.next());
		System.out.println();
		for (StoryCharaters c : new CharatersGenerator(5))
			System.out.println(c);
	}
} /*
 * Output: Americano 0 Latte 1 Americano 2 Mocha 3 Mocha 4 Breve 5 Americano 6
 * Latte 7 Cappuccino 8 Cappuccino 9
 */// :~
