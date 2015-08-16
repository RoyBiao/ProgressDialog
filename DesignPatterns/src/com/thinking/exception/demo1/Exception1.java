package com.thinking.exception.demo1;

public class Exception1 extends Exception {
	private static final long serialVersionUID = 1L;

	public Exception1() {
		super();
	}

	public Exception1(String e) {
		super(e);
	}

	public void test() throws Exception1 {
		System.out.println("test");
		//throw new Exception1("exception1");
	}

	public static void main(String[] args) {
		Exception1 exception1 = new Exception1();
		try {
			exception1.test();
		} catch (Exception e) {
			System.out.println("Caught Exception");
			System.out.println("getMessage():" + e.getMessage());
			System.out.println("getLocalizedMessage():"
					+ e.getLocalizedMessage());
			System.out.println("toString():" + e);
			System.out.println("printStackTrace():");
			e.printStackTrace(System.out);
		} finally {
			System.out.println("finally");
		}
		
		System.out.println();
		
		try {
			throw new Exception("My Exception");
		} catch (Exception e) {
			System.out.println("Caught Exception");
			System.out.println("getMessage():" + e.getMessage());
			System.out.println("getLocalizedMessage():"
					+ e.getLocalizedMessage());
			System.out.println("toString():" + e);
			System.out.println("printStackTrace():");
			e.printStackTrace(System.out);
		}
	}
}
