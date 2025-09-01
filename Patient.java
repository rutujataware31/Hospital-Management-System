package HospitalManagementSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class Patient {
        private Connection connection;
        private Scanner scanner;
        
        public Patient(Connection connection ,Scanner scanner) {
        	this.connection =connection;
        	this.scanner = scanner;
 }
        public void addPatient() {
        	System.out.print("Enter Patient Name: ");
        	String name = scanner.next();
        	System.out.print("Enter Patient Age: ");
        	int age = scanner.nextInt();
        	System.out.print("Enter Patient Gender: ");
        	String gender =scanner.next();
        	try {
        		String query = "INSERT INTO Patients(name , age , gender )VALUES(?,?,?)";
        		PreparedStatement preparedStatement = connection.prepareStatement(query);
        		preparedStatement.setString(1,name);
        		preparedStatement.setInt(2,age);
        		preparedStatement.setString(3,gender);
        		
        		int affectedrows = preparedStatement.executeUpdate();
        		if(affectedrows >0) {
        			System.out.println("Patient Added Successfully!!");	
        		}else {
        			System.out.println("Failed to add Patients!!");
        		}
        		
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }  
        
        
        public void viewPatients() {
        	String query = "select * from Patients" ;
        	try {
        		PreparedStatement preparedStatement = connection.prepareStatement(query);
        		ResultSet resultSet = preparedStatement.executeQuery();
        		System.out.println("\nPatients: ");
        		System.out.println("+------------+----------------------+-------+----------+");
        	    System.out.println("| Patient Id | Name                 | Age   | Gender   |");
        	    System.out.println("+------------+----------------------+-------+----------+");
        		while(resultSet.next()) {
        			int id = resultSet.getInt("id");
        			String name = resultSet.getString("name");
        			int age = resultSet.getInt("age");
        			String gender = resultSet.getString("gender");
                    System.out.printf("| %-10d | %-20s | %-5d | %-8s |\n", id, name, age, gender);
        		}
                System.out.println("+------------+----------------------+-------+----------+");

        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
        }
        
        
        public boolean getPatientById(int id) {
        	String query = "select *from Patients where id =? ";
        	try {
        		PreparedStatement preparedStatement = connection.prepareStatement(query);
        		preparedStatement.setInt(1, id);
        		ResultSet resultSet = preparedStatement.executeQuery();
        		if(resultSet.next()) {
        			return true;
        		}else {
        			return false;
        		}
        		
        	}catch(SQLException e) {
        		e.printStackTrace();
        	}
			return false;
        }
}
