package com.kishan.springboot.testapis.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishan.springboot.testapis.entities.Employee;
import com.kishan.springboot.testapis.test.Customer;

@Repository
public class EmployeeDaoHibernate {
	
    @Autowired
    private SessionFactory sessionFactory;
 
    public List<Employee> getAllEmployees(){
    	Session session =  this.sessionFactory.getCurrentSession();
        List<Employee>  employeeList = session.createQuery("from Employee").list();
    	return employeeList;
    }

	public String addRandomEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        int employeeId = (Integer) session.save(employee);
        session.flush();
        session.getTransaction().commit();
        session.evict(employee);
        session.clear();
        System.out.println("A random employee saved with id: " + employeeId);
        return "saved random employee:" + employee;
	}

}
