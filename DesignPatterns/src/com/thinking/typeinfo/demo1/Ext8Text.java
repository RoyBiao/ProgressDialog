package com.thinking.typeinfo.demo1;

class A {}

class B extends A {}

class C extends B {}

public class Ext8Text {

	public static void Hierarchy(Object o) {
	
		Object[] fields = o.getClass().getDeclaredFields();
		if(fields.length == 0)
			System.out.println(o.getClass() + " has no fields");
		if(fields.length > 0) {
			System.out.println("Field(s) of " + o.getClass() + ":");
			for(Object obj : fields) 
				System.out.println(" " + obj);
		}
		
		if(o.getClass().getSuperclass() != null) {		
			System.out.println(o.getClass() + " is a subclass of " + 
				o.getClass().getSuperclass()); 
			try {
				Hierarchy(o.getClass().getSuperclass().newInstance());
			} catch(InstantiationException e) {
				System.out.println("Unable to instantiate obj");
			} catch(IllegalAccessException e) {
				System.out.println("Unable to access");
			}
		} 
		
	}		
	public static void main(String[] args) {
		Hierarchy(new C());
		
		char[] c = new char[10];
		// c is an Object:		
		System.out.println("Superclass of char[] c: " + 
			c.getClass().getSuperclass());
		System.out.println("char[] c instanceof Object: " + 
			(c instanceof Object));
	}
}