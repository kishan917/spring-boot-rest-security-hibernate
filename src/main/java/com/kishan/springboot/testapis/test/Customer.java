package com.kishan.springboot.testapis.test;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/*
 * This is our model class and it corresponds to Customer table in database
 */
@Entity
@Table(name="CUSTOMER")
public class Customer{
 
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    int id;
 
    @Column(name="customerName")
    String customerName; 
 
    @Column(name="email")
    String email;
 
    public Customer() {
        super();
    }
    public Customer(String customerName,String email) {
        super();
        this.customerName=customerName;
        this.email=email;
    }
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
	@Override
	public String toString() {
		return "Customer [id=" + id + ", customerName=" + customerName + ", email=" + email + "]";
	}
 
}