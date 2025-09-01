package HospitalManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Doctors{
	 private Connection connection;
	 
    public Doctors(Connection connection ) {
    	this.connection =connection;
}
     
    public void viewDoctors() {
    	String query = "select * from Doctors" ;
    	try {
    		PreparedStatement preparedStatement = connection.prepareStatement(query);
    		ResultSet resultSet = preparedStatement.executeQuery();
    		System.out.println("Doctors: ");
    		System.out.println("+-----------+----------------------+-----------------+");
            System.out.println("| Doctor Id | Name                 | Dept            |");
            System.out.println("+-----------+----------------------+-----------------+");
    		while(resultSet.next()) {
    			int id = resultSet.getInt("id");
    			String name = resultSet.getString("name");
    			String dept = resultSet.getString("dept");
    			System.out.printf("| %-9d | %-20s | %-15s |\n", id, name, dept);

    		}
    		 System.out.println("+-----------+----------------------+-----------------+");    			
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    
    public boolean getDoctorById(int id) {
    	String query = "select *from Doctors where id =? ";
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



