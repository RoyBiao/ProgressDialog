//: generics/Fibonacci.java
// Generate a Fibonacci sequence.
package com.thinking.generic.demo02;

import java.util.Iterator;

import com.thinking.typeinfo.demo2.Generator;

public class Fibonacci implements Generator<Integer>, Iterable<Integer> {
	private int count = 0;
	private int m;

	public Fibonacci() {

	}

	public Fibonacci(int n) {
		m = n;
	}

	public Integer next() {
		return fib(count++);
	}

	private int fib(int n) {
		if (n < 2)
			return 1;
		return fib(n - 2) + fib(n - 1);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public Integer next() {
				m--;
				return Fibonacci.this.next();
			}

			@Override
			public boolean hasNext() {
				return m > 0;
			}
		};
	}

	public static void main(String[] args) {
		Fibonacci gen = new Fibonacci();
		for (int i = 0; i < 18; i++)
			System.out.print(gen.next() + " ");
		System.out.println();
		
		Fibonacci fibonacci=new Fibonacci(18);
		Iterator<Integer> iterator= fibonacci.iterator();
		while(iterator.hasNext()){
			System.out.print(iterator.next() + " ");
		}
	}
} /*
 * Output: 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
 */// :~
