package com.jdbc.demo;

public class Employee {
	private int empId;
	private String empName;
	private String empAddress;
	private float empMarks;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public float getEmpMarks() {
		return empMarks;
	}

	public void setEmpMarks(float empMarks) {
		this.empMarks = empMarks;
	}

	public Employee(int empId, String empName, String empAddress, float empMarks) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
		this.empMarks = empMarks;
	}
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empAddress=" + empAddress + ", empMarks="
				+ empMarks + "]";
	}

}
