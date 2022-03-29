package com.kishan.springboot.testapis.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="EMPLOYEE_ID")
	private int employeeId;
	
	@Column(name="EMPLOYEE_NAME")
	private String employeeName;
	
	@Column(name="EMPLOYEE_DEPARTMENT")
	private String employeeDepartment;
	
	@Column(name="EMPLOYEE_SALARY")
	private long employeeSalary;

	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, String employeeDepartment, long employeeSalary) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeSalary = employeeSalary;
	}
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public long getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", employeeDepartment=" + employeeDepartment
				+ ", employeeSalary=" + employeeSalary + "]";
	}
	

}
