package com.akash.learning;

import java.sql.*;

public class StudentDAO {
	
	Connection connection = null;
	Statement statement = null;
	PreparedStatement preparedStatement = null;
	
	
	public void connect() {
		 try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aliens","root","Akashvijay@007");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public Student getStudent(int id) {
		try {
			String queryString = "select name from students where id = "+id;
			Student student = new Student();
			student.id = id;
			
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			
			resultSet.next();
			String resultName = resultSet.getString("name");
			
			student.name = resultName;
			
			return student;
			
		}
		catch (SQLException e) {
			System.out.println(e+" : No result found ! ");
		}
		
		return null;
	}
	
	
	public void getAllStudentData() {
		try {
			String queryString = "select * from students";
		
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(queryString);
			
			while(resultSet.next()) {
				System.out.println(resultSet.getInt(1)+" : " +resultSet.getString(2));
			}
			
		}
		catch (SQLException e) {
			System.out.println(e+" : No result found ! ");
		}
		
	}
	
	
	public void addStudent(Student s) {
		
		try {
			String queryString = "insert into students values (?,?)";
			
			preparedStatement = connection.prepareStatement(queryString);
			
			preparedStatement.setInt(1, s.id);
			preparedStatement.setString(2, s.name);
			
			int rows = preparedStatement.executeUpdate();
			
			System.out.println(rows+" row/s created...");
			
		} catch (SQLException e) {
			System.out.println(e);
		}
		
		
		
	}
	
	public void updateStudent(Student student) {
		try {
			String queryString = "update students set name = ? where id = "+student.id;
			
			preparedStatement = connection.prepareStatement(queryString);
			
			preparedStatement.setString(1, student.name);
			
			int rows = preparedStatement.executeUpdate();
			
			System.out.println(rows+" row/s updated...");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	public void deleteStudent(int id) {
		try {
			String queryString = "delete from students where id = "+id;
			
			statement = connection.createStatement();
			
			int rows = statement.executeUpdate(queryString);
			
			System.out.println(rows+" row/s deleted...");
			
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public void close() {
		try {
			connection.close();
			
			if(statement != null) statement.close();
			if(preparedStatement != null) preparedStatement.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}

	
}
