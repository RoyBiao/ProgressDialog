//: control/VowelsAndConsonants.java
// Demonstrates the switch statement.
package com.thinking.enumerated.demo07;

import static com.thinking.util.Print.print;
import static com.thinking.util.Print.printnb;

import java.util.Random;

public class VowelsAndConsonants {
	enum ZIMU {
		VOVEL('a', 'e', 'i', 'o', 'u'), SOMETIMES_A_VOVEL('y', 'w'), INSTANCE;
		char[] cs = null;

		ZIMU(char... cs) {
			for (int i = 0; i < cs.length; i++) {
				System.out.println(cs[i]);
			}
			this.cs = cs;
		}
	}

	public static ZIMU getChar(char c) {
		for (int i = 0; i < ZIMU.VOVEL.cs.length; i++) {
			if(c== ZIMU.VOVEL.cs[i]){
				return ZIMU.VOVEL;
			}
		}
		
		for (int i = 0; i < ZIMU.SOMETIMES_A_VOVEL.cs.length; i++) {
			if(c== ZIMU.SOMETIMES_A_VOVEL.cs[i]){
				return ZIMU.SOMETIMES_A_VOVEL;
			}
		}
		
		return ZIMU.INSTANCE;
	}

	public static void main(String[] args) {
		Random rand = new Random(47);
		for (int i = 0; i < 100; i++) {
			int c = rand.nextInt(26) + 'a';
			ZIMU zimu = getChar((char) c);
			printnb((char) c + ", " + c + ": ");
			switch (zimu) {
			case VOVEL:
				print("vowel");
				break;
			case SOMETIMES_A_VOVEL:
				print("Sometimes a vowel");
				break;
			case INSTANCE:
				print("consonant");
				break;
			default:
				break;
			}
		}
	}
} /*
 * Output: y, 121: Sometimes a vowel n, 110: consonant z, 122: consonant b, 98:
 * consonant r, 114: consonant n, 110: consonant y, 121: Sometimes a vowel g,
 * 103: consonant c, 99: consonant f, 102: consonant o, 111: vowel w, 119:
 * Sometimes a vowel z, 122: consonant ...
 */// :~
