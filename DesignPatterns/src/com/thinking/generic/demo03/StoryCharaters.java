package com.thinking.generic.demo03;

public class StoryCharaters {
	private static long counter = 0;
	private final long id = counter++;

	public String toString() {
		return getClass().getSimpleName() + " " + id;
	}
}
