package com.weeklyTask;

import java.util.Scanner;

class Student {
	int id;
	String name;
	String course;
	float marks;

	public Student(int id, String name, String course, float marks) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.marks = marks;
	}

	public void show() {
		System.out.println("ID : " + this.id);
		System.out.println("Name : " + this.name);
		System.out.println("Course : " + this.course);
		System.out.println("Marks : " + this.marks);
	}
}

public class ClassAttributes {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter the number of inputs you want - ");
		int numOfInputs = sc.nextInt();
		System.out.println();

		Student[] studentsArr = new Student[numOfInputs];

		System.out.println("Please enter details for " + numOfInputs +" students.\n");
		for (int i = 0; i < numOfInputs; i++) {
			System.out.print("Student " + i);
			System.out.print("Enter student id - ");
			int stid = sc.nextInt();
			System.out.println();

			System.out.print("Enter student name - ");
			String name = sc.next();
			System.out.println();

			System.out.print("Enter student course - ");
			String course = sc.next();
			System.out.println();

			System.out.print("Enter student marks - ");
			int marks = sc.nextInt();
			System.out.println("---");

			Student stud = new Student(stid, name, course, marks);

			studentsArr[i] = stud;
		}
		
		for (int i = 0; i < numOfInputs; i++) {
			System.out.println("---------------------------------------------------");
			studentsArr[i].show();
			System.out.println("---------------------------------------------------");
		}

	}

}
