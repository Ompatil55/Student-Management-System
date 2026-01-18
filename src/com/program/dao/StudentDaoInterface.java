package com.program.dao;

import com.program.model.Student;

public interface StudentDaoInterface {
	
	public boolean insertStudent(Student s);
	public boolean delete(int roll);
	public boolean update(int roll, String update, int ch, Student std);
	public void showAllStudent();
	public boolean showStudentById(int roll);
	

	
}
