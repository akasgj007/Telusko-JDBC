package com.akash.learning;

import java.util.Scanner;

public class Demo {
	
	
	public static boolean wishToContinue(Scanner scanner) {
	    System.out.println("Do you wish to continue ? Enter Y/N : ");
	    String input = scanner.nextLine().trim().toLowerCase(); // Read the whole line, trim whitespace, and convert to lowercase

	    // Check if input is "y" or "n"
	    while (!input.equals("y") && !input.equals("n")) {
	        System.out.println("Invalid input. Please enter 'Y' or 'N'.");
	        input = scanner.nextLine().trim().toLowerCase(); // Prompt user again for input
	    }

	    return input.equals("y"); // Return true if input is "y", false otherwise
	}

	
	public static void main(String[] args) {
		
		
		
		try {
			Scanner scanner = new Scanner(System.in);
			StudentDAO dao = new StudentDAO();
			dao.connect();
			
			do {
				
				System.out.println("Welcome to Student Database...");
				System.out.println();
				System.out.println("Please choose one of following services...");
				System.out.println();
				System.out.println(" 1. Get Student By Id\n 2. Get All Students\n 3. Add a Student record\n 4. Update a Student record\n 5. Delete a Student record");
				System.out.println("\n Enter option here...");
		
				int choice;
				String input = scanner.nextLine().trim(); // Read the whole line and trim whitespace

				// Check if input is not empty and contains only digits
				if (!input.isEmpty() && input.matches("\\d+")) {
				    choice = Integer.parseInt(input);
				} else {
				    System.out.println("Invalid input. Please enter a valid number.");
				    continue; // Restart the loop to prompt the user again
				}

				
				
				switch (choice) {
					case 1 : {
						System.out.println("Sure...");
						System.out.println("Please enter id of student to fetch: ");
						int id = Integer.parseInt(scanner.nextLine().trim());
						Student student = dao.getStudent(id);
						System.out.println("Result : "+student.id+" - "+student.name);	
						
					}; break;
					
					case 2: {
						System.out.println("********** Students Table ********** ");
						dao.getAllStudentData();
						System.out.println("********** ********** ********** **********");
					}; break;
					
					case 3: {
						System.out.println("Ofcourse...");
						System.out.println("Please enter id of student : ");
						int id = Integer.parseInt(scanner.nextLine().trim());
						System.out.println("Please enter name of student : ");
						String name = scanner.nextLine();
						Student student = new Student(id,name);
						dao.addStudent(student);
						
						
					}; break;
					
					case 4: {
						System.out.println("Yeah sure...");
						System.out.println("Please enter id of student to update: ");
						int id = Integer.parseInt(scanner.nextLine().trim());
						System.out.println("Please enter the updated name of student : ");
						String name = scanner.nextLine();
						Student student = new Student(id,name);
						dao.updateStudent(student);
						
						
					};break;
					
					case 5: {
						System.out.println("Oops Okay if you say so :< ");
						System.out.println("Please enter id of student to delete: ");
						int id = Integer.parseInt(scanner.nextLine().trim());
						dao.deleteStudent(id);
					};break;
					
					default :{ 
						System.out.println("Sorry, Please enter correct choice to continue...");
					}
					
				}	
			}while(wishToContinue(scanner));
			
			System.out.println("Thanks for the visit,come again...");
		

			dao.close();
		}
		
		catch(Exception e) {
			System.out.println("Sorry Try again");
		}

		
		
		

		// Create
//	Student s1 = new Student(7,"Amul");
////	dao.addStudent(s1);
//	
//	// Read
//	Student s2 = dao.getStudent(2);
//	System.out.println("Get Before Update Result : "+s2.id+" - "+s2.name);
//			
//	// Update
//	dao.updateStudent(2,"Ratchasi");
//	Student s3 = dao.getStudent(2);
//	System.out.println("Get After Update Result : "+s3.id+" - "+s3.name);
//	
		
		// Delete
//		dao.deleteStudent(6);
		
		
		
		
		//Class.forName("com.mysql.jdbc.Driver");

		//DDL - Change definition of table (create,delete)
		//DML - manipulate the data (update) executeUpdate() => return integer;
		//DQL - Querying data (select) executeQuery() => return ResultSet;
//		
//		String urlString = "jdbc:mysql://localhost:3306/aliens";
//		String userNameString = "root";
//		String passwordString = "Akashvijay@007";
//		
//		int userId = 6; String userName = "Naveen";
//		
//		String queryString = "insert into students values (" +userId+ ",'"+userName+"')";
		
//		String queryString = "insert into students values (?,?)";
		
//		Connection connection = DriverManager.getConnection(urlString,userNameString,passwordString);
		
		//PreparedStatement for fetching dynamic values into query
		
//		PreparedStatement preparedStatement = connection.prepareStatement(queryString);
//		preparedStatement.setInt(1, userId);
//		preparedStatement.setString(2, userName);
//		
//		Statement statement = connection.createStatement();
		
//		ResultSet resultSet = statement.executeQuery(queryString);
//		
//		while(resultSet.next()) {
//			System.out.println(resultSet.getInt(1)+" : " +resultSet.getString("name"));
//		}

//		int count = preparedStatement.executeUpdate();
//		
//		System.out.println(count+" row/s affected...");
//		
//		preparedStatement.close();
//		connection.close();
		
	}
}
