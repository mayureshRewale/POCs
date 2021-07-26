package com.weeklyTask;

public class HasARelation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project p1 = new Project(1, "Mobile Application", "Navi Mumbai");
		Project p2 = new Project(2, "Web Application", "Thane");
		Employee em1 = new Employee("Steve", p1, 25000, 100);
		Employee em2 = new Employee("Bukenen", p2, 24000, 103);
		Employee em3 = new Employee("Tony", p1, 30000, 106);
		Employee em4 = new Employee("Bruce", p2, 30000, 108);
		
		
	}

}

final class Employee{
	int eId;
	String eName;
	int eSal;
	Project ePro;
	
	Employee(String name, Project project, int salary, int id){
		this.eName = name;
		this.ePro = project;
		this.eSal = salary;
		this.eId = id;
	}
	
	public void display() {
		System.out.println("Employee Id : " + eId);
		System.out.println("Employee Name : " + eName);
		System.out.println("Employee Salary : " + eSal);
		System.out.println("Employee Project : " + ePro.pName);
		System.out.println("Employee Project ID : " + ePro.pId);
		System.out.println("Employee Project Location : " + ePro.pLoc);
		System.out.println("------------------------------------------");
	}
	
	
}

final class Project{
	int pId;
	String pName;
	String pLoc;
	
	Project(int id, String name, String loc){
		this.pId = id;
		this.pName = name;
		this.pLoc = loc;
	}
}
