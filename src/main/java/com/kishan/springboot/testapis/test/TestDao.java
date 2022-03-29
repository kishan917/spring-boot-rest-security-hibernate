package com.kishan.springboot.testapis.test;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kishan.springboot.testapis.entities.Employee;


@Repository
public class TestDao {
	
    @Autowired
    private SessionFactory sessionFactory;
 
	public void test() {

		Session session;

        session = this.sessionFactory.getCurrentSession();
        List<Customer>  customerList = session.createQuery("from Customer").list();
        System.out.println("customerList obj : " + customerList);
        
        session = this.sessionFactory.getCurrentSession();
        List<Employee>  empList = session.createQuery("from Employee").list();
        System.out.println("empList obj : " + empList);
        
        Employee emp = new Employee(101, "Emp101", "Dept101", 101);
        session.beginTransaction();
        session.save(emp);
        session.flush();
        session.getTransaction().commit();
        session.evict(emp);
        session.clear();
        session.clear();
        
        session = this.sessionFactory.getCurrentSession();
        List<Employee>  empList2 = session.createQuery("from Employee").list();
        System.out.println("empList2 obj : " + empList2);
		
	}

}
