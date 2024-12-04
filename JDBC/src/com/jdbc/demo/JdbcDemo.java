package com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		System.out.println("main started!!");
		Connection connection = null;

		List<Employee> empList = new ArrayList<Employee>();

		// Step-1 Register the driver class (Note - In Latest JDK versions, this step is
		// optional
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Create the Connection Object

			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "root");
			// step-3 Create Statement/Prepared Statement Object
			Statement statement = connection.createStatement();
			// step -4 Execute the Query
			ResultSet rs = statement.executeQuery("Select * from employees where empMarks < 95 ");

			while (rs.next()) {
				int empId = rs.getInt(1);
				String empName = rs.getString(2);
				String empAddress = rs.getString(3);
				float empMarks = rs.getFloat(4);

				System.out.println("Fetched row from DB: " + "empid = " +  empId + ", "  + "empName = "  + empName
						 + ", "	+ "empAddress=  "  + empAddress + ", " + "empMarks = " + empMarks);

				Employee emp = new Employee(empId, empName, empAddress, empMarks);
				empList.add(emp);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("111 Some error occurred during connecting to DB !!" + e.getMessage());
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("222 Some error occurred during connecting to DB !!" + e.getMessage());
		} catch (Exception e) {
			System.out.println("Some error occurred !!" + e.getMessage());
		}

		finally {
			// step-5 -Close the COnnection
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		System.out.println("Employees from Database: " + empList);

		System.out.println("main ended!!");
	}

}
