//: typeinfo/ShowMethods.java
// Using reflection to show all the methods of a class,
// even if the methods are defined in the base class.
// {Args: ShowMethods}
package com.thinking.typeinfo.demo5;

import java.lang.reflect.*;
import java.util.regex.*;

public class ShowMethods {
	private static String usage = "usage:\n"
			+ "ShowMethods qualified.class.name\n"
			+ "To show all methods in class or:\n"
			+ "ShowMethods qualified.class.name word\n"
			+ "To search for methods involving 'word'";
	
	private ShowMethods(){}
	private static Pattern p = Pattern.compile("(native\\s{1}|final\\s{1})|(\\w+\\.)");

	public static void main(String[] args) {
//		if (args.length < 1) {
//			System.out.println(usage);
//			System.exit(0);
//		}
		args =new String[]{"com.thinking.typeinfo.demo1.ToyTest"};
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if (args.length == 1) {
				for (Method method : methods)
					System.out.println(p.matcher(method.toString()).replaceAll(
							""));
				for (Constructor ctor : ctors)
					System.out.println(p.matcher(ctor.toString())
							.replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for (Method method : methods)
					if (method.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(method.toString())
								.replaceAll(""));
						lines++;
					}
				for (Constructor ctor : ctors)
					if (ctor.toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor.toString())
								.replaceAll(""));
						lines++;
					}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
} /*
 * Output: public static void main(String[]) public native int hashCode() public
 * final native Class getClass() public final void wait(long,int) throws
 * InterruptedException public final void wait() throws InterruptedException
 * public final native void wait(long) throws InterruptedException public
 * boolean equals(Object) public String toString() public final native void
 * notify() public final native void notifyAll() public ShowMethods()
 */// :~
