package com.program.dao;

import java.sql.*;

import com.program.db.DBConnection;
import com.program.model.Student;

public class StudentDao implements StudentDaoInterface{

	@Override
	public boolean insertStudent(Student s) {
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "insert into student_details(sname, clgname, city, percentage) values(?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(query);
			pst.setString(1, s.getName());
			pst.setString(2, s.getClgName());
			pst.setString(3, s.getCity());
			pst.setDouble(4, s.getPercentage());
			pst.executeUpdate();
			flag = true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
		return flag;
	}
	

	@Override
	public boolean delete(int roll) {
		boolean flag = false;
		try {
			Connection con = DBConnection.createConnection();
			String query = "delete from student_details where rollno="+roll;
			PreparedStatement pst = con.prepareStatement(query);
			pst.executeUpdate();
			flag  = true;
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
    @Override
	public boolean update(int roll, String update, int ch, Student s) {
		int choice = ch;
		boolean flag = false;
		try {
			if(choice == 1) {
				Connection con = DBConnection.createConnection();
				String query="update student_details set sname=? where rollno=?";
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, update);
				ps.setInt(2, roll);
				ps.executeUpdate();
				flag = true;
			   }
			else if(choice == 2){
				Connection con = DBConnection.createConnection();
				String query="update student_details set clgname=? where rollno=?";
				
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, update);
				ps.setInt(2, roll);
				ps.executeUpdate();
				flag = true;
			}
		    }
            catch(Exception ex) {
				ex.printStackTrace();
			} 
            return flag;
		}		
			
	@Override
	public void showAllStudent() {
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from student_details";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("RollNumber:-"+rs.getInt(1)+"\n"+
			                     "Name:-"+rs.getString(2)+"\n"+
						        "Clg name:-"+rs.getString(3)+"\n"+
						        "City:-"+ rs.getString(4)+"\n"+
						        "Percentage:-"+rs.getDouble(5));
				 System.out.println("------------------------------------");
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
	}

	@Override
	public boolean showStudentById(int roll) {
		try {
			Connection con = DBConnection.createConnection();
			String query = "select * from student_details where rollno="+ roll;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("RollNumber:-"+rs.getInt(1)+"\n"+
			                     "Name:-"+rs.getString(2)+"\n"+
						        "Clg name:-"+rs.getString(3)+"\n"+
						        "City:-"+ rs.getString(4)+"\n"+
						        "Percentage:-"+rs.getDouble(5));
				 System.out.println("------------------------------------");
			}
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	
	
		return false;
	}
	

}
