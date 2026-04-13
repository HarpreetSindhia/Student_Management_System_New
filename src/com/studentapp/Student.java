package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	private String name;
	private int age;
	private String studentID;
	private List<String> courses;

	public Student(String name, int age, String studentID)
	{
		if(validateAge(age) && validateName(name) && validateStudentID(studentID))
		{
		this.name = name;
		this.age = age;
		this.studentID = studentID;
		courses =	new ArrayList<>();
	}
	}

	public String getName()
	{
		return name;
	}

	public int getAge()
	{
		return age;
	}

	public String getStudentID()
	{
		return studentID;
	}

	public List<String> getCourses()
	{
		return courses;
	}

	public void enrollCourse(String course)
	{
		if(validateCourseName(course))
		{
		if(!courses.contains(course) && validateCourseName(course))
		{
			courses.add(course);

			System.out.println("Student is enrolled to " + course + " successfully");
		}
		else
		{
			System.err.println("Student is already enrolled to " + course);
		}
		}
	}


	public void printStudentInfo()
	{
		System.out.println("------ Student Information ------");
		System.out.println("Student Name : " + name);
		System.out.println("Student Age : " + age);
		System.out.println("Student ID : " + studentID);
		System.out.println("Enrolled for courses : " + courses);
	}

	@Override
	public String toString()
	{
		return String.format("Student[name = %s , age = %d, studentID = %s , courses = %s]",name , age , studentID , courses);
	}

	//Validation Check
	public static Boolean validateAge(int age)
	{
		if(age >= 19 && age <= 35)
		{
			return true;
		}
		else
		{
			System.err.println("Invalid Age! age needs to be between 19 and 35");
			return false;
		}
	}

	public static	Boolean validateName(String name)
	{
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern =	Pattern.compile(nameRegex);
		Matcher nameMatcher =	namePattern.matcher(name);
		if(nameMatcher.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Invalid Name!!! Please enter alphabets only");
			return false;
		}
	}

	public static	Boolean validateStudentID(String studentID)
	{
		String studentIDRegex = "S-\\d+$";
		Pattern studentIDPattern =	Pattern.compile(studentIDRegex);
		Matcher studentIDMatcher =	studentIDPattern.matcher(studentID);
		if(studentIDMatcher.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Invalid student ID !!! Format must be S-123");
			return false;
		}
	}

	public Boolean validateCourseName(String course)
	{
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("Devops") || course.equalsIgnoreCase("Playwright"))
		{
			return true;
		}
		else
		{
			System.err.println("Please select from the valid courses [Java , Devops , Playwright]");
			return false;
		}
	}

}
