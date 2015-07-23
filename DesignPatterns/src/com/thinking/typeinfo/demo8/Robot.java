//: typeinfo/Robot.java
package com.thinking.typeinfo.demo8;

import java.util.*;

import com.thinking.typeinfo.demo7.Null;

public interface Robot {
	String name();

	String model();

	List<Operation> operations();

	class Test {
		public static void test(Robot r) {
			if (r instanceof Null)
				System.out.println("[Null Robot]");
			System.out.println("Robot name: " + r.name());
			System.out.println("Robot model: " + r.model());
			for (Operation operation : r.operations()) {
				System.out.println(operation.description());
				operation.command();
			}
		}
	}
} // /:~
