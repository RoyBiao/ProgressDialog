package cn.ry.diary.junit.test01;

import junit.framework.TestCase;

public class TestCalcuator extends TestCase {
	public void testAdd() {
		Calcuator calcuator = new Calcuator();
		double result = calcuator.add(1, 2);
		assertEquals(2, result, 0);
	}
}
