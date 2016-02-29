//: holding/EnvironmentVariables.java
package com.thinking.collection.demo7;

import java.util.Map;

public class EnvironmentVariables {
	public static void main(String[] args) {
		for (Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}
} /* (Execute to see output) */// :~
