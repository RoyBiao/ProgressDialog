package com.thinking.typeinfo.demo1;

import java.util.Arrays;
import java.util.List;

abstract class Shape {
	void draw() {
		System.out.println(this + ".draw()");
	}

	abstract public String toString();
}

class Circle extends Shape {
	boolean flag = false;

	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Circle"; 
	}

	public void rotate() {
		System.out.println("Circle rotate ...");
	}
}

class Square extends Shape {
	boolean flag = false;

	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Square"; 
	}
}

class Triangle extends Shape {
	boolean flag = false;

	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Triangle"; 
	}
}

class Rhomboid extends Shape {
	boolean flag = false;

	public String toString() { 
		return (flag ? "H" : "Unh") + "ighlighted " + "Rhomboid"; 
	}
}

public class ShapeTest {
	public static void setFlag(Shape s) {
		if (s instanceof Triangle)
			((Triangle) s).flag = true;
	}

	public static void main(String[] args) {
		// upcasting to Shape:
		List<Shape> shapeList = Arrays.asList(new Circle(), new Square(),
				new Triangle(), new Rhomboid());
		// downcasting back to specific shape:
		for (Shape shape : shapeList) {
			setFlag(shape);
			shape.draw();
		}

		Circle r = new Circle();
		Shape s = ((Shape) r);
		s.draw();
		if (s instanceof Circle) {
			s.draw();
			((Circle) s).rotate();
		} else if (s instanceof Square) {
			s.draw();
		} else if (s instanceof Triangle) {
			s.draw();
		} else if (s instanceof Rhomboid) {
			s.draw();
		}
		// inconvertible types:
		// ((Circle)((Shape)r)).draw();
	}
}