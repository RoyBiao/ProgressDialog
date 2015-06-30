package cn.ry.diary.demo.exception;

import android.test.AndroidTestCase;

public class NegativeAgeExceptionTest extends AndroidTestCase{

	public void test(){
		try {
			int age = -1;

			if (age < 0)
				throw new NegativeAgeException("Please enter a positive age");
			else
				System.out.println("age:" + age);
		} catch (NegativeAgeException e) {
			System.out.println(e);
		}
	}

}
