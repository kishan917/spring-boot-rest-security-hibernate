package com.kishan.springboot.testapis.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.kishan.springboot.testapis.entities.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer>{
	
	@Query(value = "SELECT emp FROM Employee emp WHERE emp.employeeDepartment = :employeeDepartment", nativeQuery = false)
	List<Employee> findByDepartmentName(@Param("employeeDepartment") String emplDept);
	
	@Query(value = "SELECT * FROM Employee emp WHERE emp.EMPLOYEE_DEPARTMENT = :employeeDepartment", nativeQuery = true)
	List<Employee> findByDepartmentName2(@Param("employeeDepartment") String emplDept);
	
	
	
	@Query(value = "SELECT emp FROM Employee emp WHERE emp.employeeName = ?1", nativeQuery = false)
	List<Employee> findByEmployeeName(String employeeName);
	
	@Query(value = "SELECT * FROM Employee emp WHERE emp.EMPLOYEE_NAME = ?1", nativeQuery = true)
	List<Employee> findByEmployeeName2(String employeeName);
	
	
	
	@Modifying
	@Query(value = "update Employee emp set emp.employeeSalary = :employeeSalary where emp.employeeName = :employeeName", nativeQuery = false)
	int updateEmployeeSalaryUsingName(String employeeName, int employeeSalary); //return number of rows updated
	
	@Modifying
	@Query(value = "update Employee emp set emp.EMPLOYEE_SALARY = ? where emp.EMPLOYEE_NAME = ?", nativeQuery = true)
	int updateEmployeeSalaryUsingName2(int employeeSalary, String employeeName);


	//same for insert query but return type void ... @Modifying @Query and insert query
	
	
	
}
