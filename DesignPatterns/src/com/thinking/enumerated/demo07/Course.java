//: enumerated/menu/Course.java
package com.thinking.enumerated.demo07;

import com.thinking.enumerated.demo07.food.Appetizer;
import com.thinking.enumerated.demo07.food.Coffee;
import com.thinking.enumerated.demo07.food.DRINK;
import com.thinking.enumerated.demo07.food.Dessert;
import com.thinking.enumerated.demo07.food.Food;
import com.thinking.enumerated.demo07.food.MainCource;
import com.thinking.util.Enums;

public enum Course {
	APPETIZER(Appetizer.class), MAINCOURSE(MainCource.class), DESSERT(
			Dessert.class), COFFEE(Coffee.class),DRINCK(DRINK.class);
	private Food[] values;

	private Course(Class<? extends com.thinking.enumerated.demo07.food.Food> kind) {
		values = kind.getEnumConstants();
	}

	public com.thinking.enumerated.demo07.food.Food randomSelection() {
		return Enums.random(values);
	}
} // /:~
