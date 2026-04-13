package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student2 {

	private String name;
	private int age;
	private String studentID;
	private List<String> courses;
	
	public Student2(String name , int age , String studentID)
	{
		if(validateAge(age) && validateName(name) && validateStudentID(studentID))
		{
			this.name = name;
			this.age = age;
			this.studentID = studentID;
			courses =	new ArrayList<String>();
		}
	}
	
	public void enrollCourse(String course)
	{
		if(validateCourse(course))
		{
			if(!courses.contains(course))
			{
				courses.add(course);
				
				System.out.println("Student enrolled to "+ course + "successfully");
			}
			else
			{
				System.err.println("Student has been already enrolled to the course " + course);
			}
		}
		
	}
	
	public void printStudentInfo()
	{
		System.out.println("Student name : " + name );
		System.out.println("Student age : " + age);
		System.out.println("Student ID : " + studentID);
		System.out.println("Courses enrolled : " + courses);
	}
	
	
	public String toString()
	{
		return String.format("Student[name = %s , age = %d , studentID = %s , courses = %s]", name , age , studentID , courses);
	}
	
	
	//Validation Checks for Instance Variables
	
	public static Boolean validateAge(int age)
	{
		if(age >= 19 && age <= 35)
		{
			return true;
		}
		else
		{
			System.err.println("Invalid Age !!! Age must be between 19 - 35");
			return false;
		}
	}
	
	public static Boolean validateName(String name)
	{
		String nameRegex = "^[a-zA-Z\\s]+$";
		//^ - represents start of string
		//a-zA-Z represents any characters allowed
		//\\s represents white space allowed between names
		// + represents any number of combinations
		// $ represents end of string
		
		Pattern namePattern =	Pattern.compile(nameRegex);
		Matcher nameMatcher =	namePattern.matcher(name);
		if(nameMatcher.matches())
		{
			return true;
		}
		else
		{
			System.err.println("Inavlid name !!! Please enter characters only");
			return false;
		}
	}
	
	public static Boolean validateStudentID(String studentID)
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
			System.err.println("Invalid Student ID - Format should be S-1234");
			return false;
		}
	}
	
	public static Boolean validateCourse(String course)
	{
		if(course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Playwright"))
		{
			return true;
		}
		else
		{
			System.err.println("Please select from the valid courses [Java , DSA , Playwright]");
			return false;
		}
		
	}
	
}
