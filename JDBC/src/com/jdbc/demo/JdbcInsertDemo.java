package com.jdbc.demo;

import java.sql.*;

public class JdbcInsertDemo {

    public static void main(String[] args) {
        // Database connection details
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root")) {
            
            // SQL query to insert a new employee
            String insertQuery = "INSERT INTO employees (empName, empAddress, empMarks) VALUES (?, ?, ?)";
            
            // Prepare the statement for executing the insert query
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                // Setting values for the placeholders in the insert query
                preparedStatement.setString(1, "Radha Rani");    // Employee Name
                preparedStatement.setString(2, "Vrundavan");  // Employee Address
                preparedStatement.setDouble(3, 81.59);   // Employee Marks

                // Execute the insert query
                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Rows inserted: " + rowsInserted);  // Print the result
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Print any SQLException encountered
        }
    }
}
