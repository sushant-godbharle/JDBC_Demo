package com.jdbc.demo;

import java.sql.*;

public class JdbcSelectDemo {

    public static void main(String[] args) {
        // Database connection details
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root")) {
            
            // SQL query to select all employees from the employees table
            String selectQuery = "SELECT * FROM employees";
            
            // Create a statement object to execute the query
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(selectQuery)) {
                
                // Iterate through the result set and print each row
                while (rs.next()) {
                    int empId = rs.getInt("empId");  // Retrieve employee ID
                    String empName = rs.getString("empName");  // Retrieve employee name
                    String empAddress = rs.getString("empAddress");  // Retrieve employee address
                    float empMarks = rs.getFloat("empMarks");  // Retrieve employee marks
                    
                    // Print the employee details
                    System.out.println("empId = " + empId + ", empName = " + empName + ", empAddress = " + empAddress
                            + ", empMarks = " + empMarks);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Print any SQLException encountered
        }
    }
}
