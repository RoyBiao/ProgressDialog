//: exceptions/LostMessage.java
// How an exception can be lost.
package com.thinking.exception.demo4;

class VeryImportantException extends Exception {
	public String toString() {
		return "A very important exception!";
	}
}

class HoHumException extends Exception {
	public String toString() {
		return "A trivial exception";
	}
}

class PoPException extends Exception {
	public String toString() {
		return "A pop exception";
	}
}

public class LostMessage {
	void f() throws VeryImportantException {
		throw new VeryImportantException();
	}

	void dispose() throws HoHumException {
		throw new HoHumException();
	}

	void pop() throws PoPException {
		throw new PoPException();
	}

	public static void main(String[] args) {
		try {
			LostMessage lm = new LostMessage();
			try {
				lm.f();
			} finally {
				lm.dispose();
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			LostMessage lmf = new LostMessage();
			try {
				lmf.f();
			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lmf.dispose();
			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}
} /*
 * Output: A trivial exception
 */// :~
