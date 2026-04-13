package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class Main3 {
	
	private static	List<Student>	studentList;

	public static void main(String[] args) {
		
	System.out.println("------ Student Management System ------");
	
	studentList = new ArrayList<Student>();
	
	Scanner scanner = new Scanner(System.in);
	
	while(true)
	{
	System.out.println("Please select from below options : ");
	
	System.out.println("1 : Register the student");
	System.out.println("2 : Find student by studentID");
	System.out.println("3 : List all student information");
	System.out.println("4 : List all student information in sorted order");
	System.out.println("5 : Exit");
	
	int option =	scanner.nextInt();
	
	switch(option)
	{
		case 1 :
		enrollStudent(scanner);
		break;
		
		case 2 :
			findStudentByID(scanner);
			break;
			
		case 3 :
			printAllStudentInformation(scanner);
			break;
			
		case 4 : 
			sortByName(scanner);
		    break;
		         
		case 5 :
			exit(scanner);
			break;
			
			default :
				System.out.println("Please select from the valid options 1 - 5");
	}
	}
	
	}
	
	private static void exit(Scanner scanner) {
		
		System.exit(0);
		
	}

	private static void sortByName(Scanner scanner) {
		
		
		Comparator<Student> nameComparator = (S1,S2) -> S1.getName().compareTo(S2.getName());
		
		Collections.sort(studentList , nameComparator);
		
		for(Student dataSort : studentList)
		{
			dataSort.printStudentInfo();
		}
		
	}
	

	private static void printAllStudentInformation(Scanner scanner)
	{
		
		if(studentList.size() > 0)
		{

			System.out.println("......... Printing Student Data .........");
			for(Student data : studentList)
			{
				data.printStudentInfo();
			}
		}
			else
			{
				System.err.println("Student List is empty !!! No Student Record found");
			}
		
		
	}

	private static void findStudentByID(Scanner scanner) {
		
		Student studentFound = null;
		System.out.println("Enter the student ID");
		String studentID =	scanner.next();
		
		try
		{
			studentFound =	studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentID)).findFirst()
			.orElseThrow(()-> new StudentNotFoundException("No student found with studentID " + studentID));
		}
		catch(StudentNotFoundException e)
		{
			System.err.println(e.getMessage());
		}
		
		studentFound.printStudentInfo();
		
	
	}	

	private static void enrollStudent(Scanner scanner) {
		
		Student newStudent = null;
		
	
				System.out.println("Please enter the student name");
				String studentName =	scanner.next();
				
				System.out.println("Please enter student age");
				int studentAge =	scanner.nextInt();
				
				System.out.println("Please enter student ID");
				String studentID =	scanner.next();
				
				newStudent = new Student(studentName , studentAge , studentID);
				
		studentList.add(newStudent);
		
		while(true)
		{
			System.out.println("Enter the course to be enrolled for and type Done to exit :");
			
			String courseName =	scanner.next();
			if(courseName.equalsIgnoreCase("Done"))
			{
				break;
			}
			
			newStudent.enrollCourse(courseName);
			
		}
		
		newStudent.printStudentInfo();
		
	}
	
	
	
	
	

	public static Student findStudentByID(String studentID)
	{
		Student result = null;
		try {
			result = studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentID))
			.findFirst().orElseThrow(() -> new StudentNotFoundException("Student with studentID " + studentID + " not found"));
		} catch (StudentNotFoundException e) {
			
			System.err.println(e.getMessage());
		}
		
		return result;
	}
	
	
	public static void sortByName()
	{
		Comparator<Student> studentNameComparator = new Comparator<Student>()
				{
					public int compare(Student o1 , Student o2)
					{
						return o1.getName().compareTo(o2.getName());
					}
				};
				
				Collections.sort(studentList, studentNameComparator);
				
				System.out.println(studentList);
	}
}
