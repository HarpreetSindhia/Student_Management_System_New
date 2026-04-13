package com.studentapp;

public class Main {

	public static void main(String[] args) {
		
	System.out.println("------ Student Management System ------");
	
	
	Student s1 = new Student("Harpreet" , 20, "S-123");
	
	s1.enrollCourse("Java");
	s1.enrollCourse("SDET");
	s1.enrollCourse("Devops");
	s1.printStudentInfo();
	
	Student s2 = new Student("Simran" , 25 , "S-125");
	s2.enrollCourse("Devops");
	s2.printStudentInfo();


	Student s3 = new Student("Lovepreet" , 28, "S-126");
	s3.enrollCourse("Java");
	s3.printStudentInfo();
	
	
	}
}
