//: enumerated/NotClasses.java
// {Exec: javap -c LikeClasses}
package com.thinking.enumerated.demo10;

import static com.thinking.util.Print.*;

enum LikeClasses {
	WINKEN {
		void behavior() {
			print("Behavior1");
		}
	},
	BLINKEN {
		void behavior() {
			print("Behavior2");
		}
	},
	NOD {
		void behavior() {
			print("Behavior3");
		}
	};
	abstract void behavior();
}

public class NotClasses {
	// void f1(LikeClasses.WINKEN instance) {} // Nope
} /*
 * Output: Compiled from "NotClasses.java" abstract class LikeClasses extends
 * java.lang.Enum{ public static final LikeClasses WINKEN;
 * 
 * public static final LikeClasses BLINKEN;
 * 
 * public static final LikeClasses NOD; ...
 */// :~
