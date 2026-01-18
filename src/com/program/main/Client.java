package com.program.main;
import java.util.Scanner;

import com.program.dao.StudentDao;
import com.program.dao.StudentDaoInterface;
import com.program.model.Student;

public class Client {
	public static void main(String[] args) {
		
		StudentDaoInterface dao = new StudentDao();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Welcom to Student Management Application");
		
		while(true) {
			System.out.println("\n1.Add Student"+
		                   "\n2.Show All Students"+
					       "\n3.Get Student based on roll number"+
		                   "\n4.Delete Student"+
					       "\n5.Update Student"+
		                   "\n6.Exit");
			System.out.println();
			
			System.out.println("Enter your choice:-");
			int ch = sc.nextInt();
			
			switch(ch) {
			case 1:
				System.out.println("Add Student:-");
				
				System.out.println("Enter Student name:-");
				String name = sc.next();
				System.out.println("Enter Student clg name:-");
				String clgName = sc.next();
				System.out.println("Enter city:-");
				String city = sc.next();
				System.out.println("Enter Percentage:-");
				double percentage = sc.nextDouble();
				
				Student st = new Student(name, clgName, city, percentage);
				boolean ans = dao.insertStudent(st);
				if(ans) {
					System.out.println("Record Inserted");
				}
				else {
					System.out.println("Something went wrong, please try again");
				}
	
				break;
				
				
			case 2:
				System.out.println("Show all Students\n");
				dao.showAllStudent();
				break;
				
				
			case 3:
				System.out.println("Get student based on rollnumber");
				System.out.println("Enter roll no:-");
				int roll = sc.nextInt();
				boolean f = dao.showStudentById(roll);
				if(!f) {
					System.out.println("Student with this id is not available in our system");
				}
				
				break;
				
				
			case 4:
				System.out.println("Delete Student");
				System.out.println("Enter roll number to delete:-");
				int rollnum = sc.nextInt();
				boolean ff = dao.delete(rollnum);
				if(ff) {
					System.out.println("Record deleted successfully..");
				}
				else {
					System.out.println("Something went wrong");
				}
				
				break;
				
				
			case 5:
				System.out.println("Update the student");
				System.out.println("\n1.Update name\n2.Update clgName");
				System.out.println("Enter your choice:-");
				int choice = sc.nextInt();
				
				switch(choice) {
				case 1:
					System.out.println("Enter roll numner:-");
					int rnum = sc.nextInt();
					System.out.println("Enter new name:-");
					String sname = sc.next();
					Student std = new Student();
					std.setName(sname);
					boolean flag = dao.update(rnum, sname, choice, std);
					if(flag) {
						System.out.println("College Name update successfully");
					}
					else {
						System.out.println("Something went wrong");
					}
					
				case 2:
					System.out.println("Enter roll numner:-");
					int rollN = sc.nextInt();
					System.out.println("Enter new college name name:-");
					String clgN = sc.next();
					Student std1 = new Student();
					std1.setClgName(clgN);
					boolean flag1 = dao.update(rollN, clgN, choice, std1);
					if(flag1) {
						System.out.println("Name update successfully");
					}
					else {
						System.out.println("Something went wrong");
					}
				}

				break;
				
				
			case 6:
				System.out.println("Thank you for using Student management system");
				System.exit(0);
				
			default:
				System.out.println("Enter valid choice");
			}
			
		}
	}

}
