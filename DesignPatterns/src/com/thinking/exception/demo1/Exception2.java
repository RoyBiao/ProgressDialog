package com.thinking.exception.demo1;

class Exception2 extends Exception {
	private static final long serialVersionUID = 1L;
	private String msg;
	public Exception2() {
	}
	public Exception2(String msg) {
		super(msg);
		System.out.println("Exception4()");
		this.msg = msg;
	}

	protected void showS() {
		System.out.println("Message from Exception4: " + msg);
	}

	public static void f() throws Exception2 {
		System.out.println("f()");
		throw new Exception2("Ouch from f()");
	}

	public static void main(String[] args) {
		try {
			f();
		} catch (Exception2 e) {
			System.err.println("Caught Exception4");
			e.printStackTrace();
			e.showS();
		}
	}
}
