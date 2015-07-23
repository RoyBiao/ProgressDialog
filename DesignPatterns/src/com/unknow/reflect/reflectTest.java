package com.unknow.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.thinking.typeinfo.demo9.A;
import com.thinking.typeinfo.demo9.ModifyingPrivateFields;

public class reflectTest {

	public static void main(String[] args) {
		// test1();
		test2();
	}

	public static void test1() {
		try {
			Class<?> clazz = Class
					.forName("com.thinking.typeinfo.demo9.Reflect");
			Object obj = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("w");
			method.setAccessible(true);
			method.invoke(obj);
			// Method[] methods = clazz.getDeclaredMethods();
			// for(Method method : methods){
			// method.setAccessible(true);
			// method.invoke(obj);
			// System.out.println(method);
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void test2() {
		try {
			Object obj = getObject("com.thinking.typeinfo.demo9.ModifyingPrivateFields");
			System.out.println("obj: " + obj.toString());
			Object innerObj = getObjectFromInnerClass(obj,"com.thinking.typeinfo.demo9.ModifyingPrivateFields$WithPrivateFinalField");
			System.out.println("innerObj : " + innerObj.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Object getObject(String className) {
		Object obj = null;
		try {
			Class c = Class.forName(className);
			if (c != null) {
				Constructor constructor = c.getDeclaredConstructor();
				if (constructor != null) {
					obj = constructor.newInstance();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	public static Object getObjectFromInnerClass(Object mod ,String clsName) {
		Object obj = null;
		try {
			Class c = Class.forName(clsName);
			if (c != null) {
				Constructor constructor = c
						.getDeclaredConstructor(new Class[] { ModifyingPrivateFields.class });
				if (constructor != null) {
					obj = constructor.newInstance(mod);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
}
