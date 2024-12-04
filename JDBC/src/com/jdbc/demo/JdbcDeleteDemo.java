package com.jdbc.demo;

import java.sql.*;

public class JdbcDeleteDemo {

    public static void main(String[] args) {
        // Database connection details
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root")) {

            // SQL query to delete an employee based on empId
            String deleteQuery = "DELETE FROM employees WHERE empId = 1";  // Use empId for deletion
            
            // Prepare the SQL statement with placeholders (?)
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {

                // Set the empId to be deleted (this is where you dynamically provide empId)
                preparedStatement.setInt(1, 6);  // For example, delete employee with empId = 6

                // Execute the delete query
                int rowsDeleted = preparedStatement.executeUpdate();

                // Check how many rows were deleted and display the result
                if (rowsDeleted > 0) {
                    System.out.println("Employee with empId = 6 deleted successfully.");
                } else {
                    System.out.println("No employee found with the provided empId.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Print any SQLException encountered
        }
    }
}
