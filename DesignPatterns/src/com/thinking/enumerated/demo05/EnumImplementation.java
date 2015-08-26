//: enumerated/cartoons/EnumImplementation.java
// An enum can implement an interface
package com.thinking.enumerated.demo05;

import java.util.Random;

import com.thinking.typeinfo.demo2.Generator;

enum CartoonCharacter implements Generator<CartoonCharacter> {
	SLAPPY, SPANKY, PUNCHY, SILLY, BOUNCY, NUTTY, BOB;
	private static Random rand = new Random(47);

	public CartoonCharacter next() {
		return values()[rand.nextInt(values().length)];
	}

	public static CartoonCharacter snext() {
		return values()[rand.nextInt(values().length)];
	}
}

public class EnumImplementation {
	public static <T> void printNext(Generator<T> rg) {
		System.out.print(rg.next() + ", ");
	}

	public static void main(String[] args) {
		CartoonCharacter cc = CartoonCharacter.BOB;
		for (int i = 0; i < 10; i++){
			printNext(cc);
			System.out.print(cc.snext() + ", ");
		}
	}
}
/*
 * Output: BOB, PUNCHY, BOB, SPANKY, NUTTY, PUNCHY, SLAPPY, NUTTY, NUTTY,
 * SLAPPY,
 */// :~
