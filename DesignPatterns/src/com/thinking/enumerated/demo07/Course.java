//: enumerated/menu/Course.java
package com.thinking.enumerated.demo07;

import com.thinking.util.*;

public enum Course {
	APPETIZER(Food.Appetizer.class), MAINCOURSE(Food.MainCourse.class), DESSERT(
			Food.Dessert.class), COFFEE(Food.Coffee.class),DRINCK(Food.DRINK.class);
	private Food[] values;

	private Course(Class<? extends Food> kind) {
		values = kind.getEnumConstants();
	}

	public Food randomSelection() {
		return Enums.random(values);
	}
} // /:~
