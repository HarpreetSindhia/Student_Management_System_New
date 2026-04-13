package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class StudentNotFoundException extends Exception
{
	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message)
	{
		super(message);
	}
}


public class Main {

	private static	List<Student>	studentList;

	public static void main(String[] args) {

	System.out.println("------ Student Management System ------");

	studentList = new ArrayList<>();

	Scanner scanner = new Scanner(System.in);

	while(true)
	{

		System.out.println("Please select from the below options : ");
		System.out.println("1 : Register the user");
		System.out.println("2 : Find the student with studentID");
		System.out.println("3 : List all the student information");
		System.out.println("4 : List all the student information in sorted order");
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
			System.out.println("Please select from the given options 1 - 5");
		}

	}
	}




	private static void exit(Scanner scanner) {

	System.exit(0);

	}



	private static void sortByName(Scanner scanner) {

		Comparator<Student> nameComparator = (S1, S2) -> S1.getName().compareTo(S2.getName());

		Collections.sort(studentList , nameComparator);

		for(Student dataSort : studentList)
		{
			dataSort.printStudentInfo();
		}

	}



	private static void printAllStudentInformation(Scanner scanner) {

		if(studentList.size() > 0)
		{

			System.out.println("--------- Printing Student Information --------- ");

			for(Student data : studentList)
			{
				data.printStudentInfo();
			}

		}

		else
		{
			System.err.println("Student list is empty !!!! No student record found");
		}
	}



	private static void findStudentByID(Scanner scanner) {

		System.out.println("Please enter the student ID");
		String studentID =	scanner.next();

		Student studentFound = null;
		try
		{
			studentFound =	studentList.stream().filter(student -> student.getStudentID().equalsIgnoreCase(studentID))
			.findFirst().orElseThrow(() -> new StudentNotFoundException("Student with id " + studentID + " not found"));

		}
		catch(StudentNotFoundException e)
		{
			System.out.println(e.getMessage());
		}

		studentFound.printStudentInfo();
	}



	private static void enrollStudent(Scanner scanner) {

			System.out.println("Please enter the student name");
			String studentName =	scanner.next();

			System.out.println("Please enter the student age");
			int studentAge =	scanner.nextInt();

			System.out.println("Please enter the student ID");
			String studentID =	scanner.next();

			Student newStudent = new Student(studentName , studentAge , studentID);
			studentList.add(newStudent);

			while(true)
			{
				System.out.println("Enter the course to be enrolled and type Done to exit");
				String course =	scanner.next();
				if(course.equalsIgnoreCase("done"))
				{
					break;
				}

				newStudent.enrollCourse(course);
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
		Comparator<Student> studentNameComparator = new Comparator<>()
				{
					@Override
					public int compare(Student o1 , Student o2)
					{
						return o1.getName().compareTo(o2.getName());
					}
				};

				Collections.sort(studentList, studentNameComparator);

				System.out.println(studentList);
	}
}
