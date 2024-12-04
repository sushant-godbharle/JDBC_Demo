package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcTryWithResources {

	public static void main(String[] args) throws SQLException {
		// Starting the main method
		System.out.println("main started!!");

		// List to hold the employee objects fetched from the database
		List<Employee> empList = new ArrayList<Employee>();

		// Step-1: Use try-with-resources to automatically close the resources after
		// execution
		try (
				// Establishing the connection to the database
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root",
						"root");

				// Creating a Statement object to execute SQL queries
				Statement statement = conn.createStatement();

				// Executing a query to fetch employees with marks less than 95
				ResultSet rs = statement.executeQuery("SELECT * FROM employees ")) {
			// Looping through the result set
			while (rs.next()) {
				// Extracting the data from the result set
				int empId = rs.getInt(1); // Employee ID (1st column in DB)
				String empName = rs.getString(2); // Employee Name (2nd column in DB)
				String empAddress = rs.getString(3); // Employee Address (3rd column in DB)
				float empMarks = rs.getFloat(4); // Employee Marks (4th column in DB)

				// Printing the fetched data to the console for viewing
				System.out.println("Fetched row: empId = " + empId + ", empName = " + empName + ", empAddress = "
						+ empAddress + ", empMarks = " + empMarks);

				// Creating an Employee object and adding it to the list
				empList.add(new Employee(empId, empName, empAddress, empMarks));
			}
		} catch (SQLException e) {
			// Handling SQL exception (e.g., connection or query issues)
			e.printStackTrace();
		}

		// Printing the list of employees fetched from the database
		System.out.println("Employees from Database: " + empList);

		// Ending the main method
		System.out.println("main ended!!");
	}
}
