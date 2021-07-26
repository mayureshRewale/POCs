package com.weeklyTask;

class Shape{
	public void area() {
		System.out.println("Calculating Area");
	}
	public void draw() {
		System.out.println("Drawing Area");
	}
}

class Circle extends Shape{
public void area() {
		System.out.println("Calculating Area of Circle");
	}
	public void draw() {
		System.out.println("Drawing Area of Circle");
	}
}

class Triangle extends Shape{
public void area() {
	System.out.println("Calculating Area of Triangle");
	}
	public void draw() {
		System.out.println("Drawing Area of Triangle");
	}
}

class Square extends Shape{
public void area() {
	System.out.println("Calculating Area of Square");
	}
	public void draw() {
		System.out.println("Drawing Area of Square");
	}
}

public class Poymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Shape sh = new Shape();
		Circle ci = new Circle();
		Triangle ti = new Triangle();
		Square sq = new Square();
		
		sh.area();
		ci.area();
		ti.area();
		sq.area();

	}

}
