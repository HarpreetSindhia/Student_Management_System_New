package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StudentNotFoundException extends Exception
{

	private static final long serialVersionUID = 1L;

	public StudentNotFoundException(String message)
	{
		super(message);
	}
}
public class Main2 {
	
	private static	List<Student>	studentList;

	public static void main(String[] args) {
		
	System.out.println("------ Student Management System ------");
	
	studentList = new ArrayList<Student>();
	
	Student s1 = new Student("Harpreet" , 20, "S-123");
	s1.enrollCourse("Java");
	s1.enrollCourse("SDET");
	s1.enrollCourse("Devops");
	
	Student s2 = new Student("Simran" , 25 , "S-125");
	s2.enrollCourse("Devops");
	
	Student s3 = new Student("Lovepreet" , 28, "S-126");
	s3.enrollCourse("Java");
	
	studentList.add(s1);
	studentList.add(s2);
	studentList.add(s3);
		
	Student result =	findStudentByID("S-1");
	
	System.out.println(result);
	
	sortByName();
	
	
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
