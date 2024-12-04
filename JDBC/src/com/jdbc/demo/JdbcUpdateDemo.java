package com.jdbc.demo;

import java.sql.*;

public class JdbcUpdateDemo {

    public static void main(String[] args) {
        // Database connection details
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root")) {

            // SQL query to update the employee's marks based on employee ID
            String updateQuery = "UPDATE employees SET empMarks = 100.00 WHERE empId = 8";

            // Prepare the SQL statement without placeholders (?)
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {

                // Execute the update query
                int rowsUpdated = preparedStatement.executeUpdate();

                // Check how many rows were updated and display the result
                if (rowsUpdated > 0) {
                    System.out.println("Employee's marks updated successfully.");
                } else {
                    System.out.println("No employee found with the provided ID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();  // Print any SQLException encountered
        }
    }
}
