package com.jdbc.demo;

import java.sql.*;

public class JdbcCrudDemo {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root")) {
            // Step 1: Read (Select) - Fetch all employee records
            String selectQuery = "SELECT * FROM employees";
            try (Statement statement = connection.createStatement();
                 ResultSet rs = statement.executeQuery(selectQuery)) {
                // Loop through the result set and print employee data
                System.out.println("Fetching employee records...");
                while (rs.next()) {
                    int empId = rs.getInt("empId");  // Get employee ID from result set
                    String empName = rs.getString("empName");  // Get employee name
                    String empAddress = rs.getString("empAddress");  // Get employee address
                    float empMarks = rs.getFloat("empMarks");  // Get employee marks (using float)

                    // Print each employee record
                    System.out.println("empId = " + empId + ", empName = " + empName + ", empAddress = " + empAddress
                            + ", empMarks = " + empMarks);
                }
            }

            // Step 2: Create (Insert) - Adding a new employee record
            String insertQuery = "INSERT INTO employees (empName, empAddress, empMarks) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1, "Alice");   // Set employee name
                preparedStatement.setString(2, "456 Oak Street");   // Set employee address
                preparedStatement.setDouble(3, 92.50);  // Set employee marks (using double)

                // Execute the insert statement and get the number of rows inserted
                int rowsInserted = preparedStatement.executeUpdate();
                System.out.println("Rows inserted: " + rowsInserted);  // Print the result
            }

            // Step 3: Update - Modifying the marks of an employee
            String updateQuery = "UPDATE employees SET empMarks = ? WHERE empId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setDouble(1, 88.00); // Set new employee marks (using double)
                preparedStatement.setInt(2, 1); // Set employee ID for which marks will be updated

                // Execute the update statement and get the number of rows updated
                int rowsUpdated = preparedStatement.executeUpdate();
                System.out.println("Rows updated: " + rowsUpdated);  // Print the result
            }

            // Step 4: Delete - Removing an employee record
            String deleteQuery = "DELETE FROM employees WHERE empId = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, 2); // Set employee ID to delete

                // Execute the delete statement and get the number of rows deleted
                int rowsDeleted = preparedStatement.executeUpdate();
                System.out.println("Rows deleted: " + rowsDeleted);  // Print the result
            }

        } catch (Exception e) {
            e.printStackTrace();  // Print any exceptions encountered during database operations
        }
    }
}

