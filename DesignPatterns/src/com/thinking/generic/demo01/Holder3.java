//: generics/Holder3.java
package com.thinking.generic.demo01;

import com.thinking.typeinfo.demo2.model.Cat;

public class Holder3<T> {
	private T a;

	public Holder3(T a) {
		this.a = a;
	}

	public void set(T a) {
		this.a = a;
	}

	public T get() {
		return a;
	}

	public static void main(String[] args) {
		Holder3<Cat> h3 = new Holder3<Cat>(new Cat());
		Cat a = h3.get(); // No cast needed
		// h3.set("Not an Automobile"); // Error
		// h3.set(1); // Error
	}
} // /:~
