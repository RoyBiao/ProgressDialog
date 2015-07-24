package com.thinking.typeinfo.demo9;

public class Reflect {
	public void f() {
		System.out.println("public Reflect.f()");
	}

	public void g() {
		System.out.println("public Reflect.g()");
	}

	void u() {
		System.out.println("package Reflect.u()");
	}

	protected void v() {
		System.out.println("protected Reflect.v()");
	}

	private void w() {
		System.out.println("private Reflect.w()");
	}
}
