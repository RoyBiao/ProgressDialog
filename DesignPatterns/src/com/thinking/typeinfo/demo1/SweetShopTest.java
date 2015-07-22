package com.thinking.typeinfo.demo1;

class Candy {
	static {
		System.out.println("Loading Candy");
	}
}

class Gum {
	static {
		System.out.println("Loading Gum");
	}
}

class Cookie {
	static {
		System.out.println("Loading Cookie");
	}
}

public class SweetShopTest {
	public static void main(String[] args) {

		System.out.println("inside main");
		new Candy();
		System.out.println("After creating Candy");
		try {
			Class.forName("Gum");
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
		System.out.println("After Class.forName(\"Gum\")");
		new Cookie();
		System.out.println("After creating Cookie");
		
		test("Gum");
	}

	public static void test(String className) {
		try {
			if (className.equals("Candy")) {
				new Candy();
			} else if (className.equals(
					"Gum")) {
				Class.forName("com.thinking.typeinfo.demo1.Gum");
			} else if (className.equals(
					"Cookie")) {
				new Cookie();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}