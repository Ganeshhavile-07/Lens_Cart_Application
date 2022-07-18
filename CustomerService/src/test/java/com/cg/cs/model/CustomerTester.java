package com.cg.cs.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.cs.entity.Customer;

public class CustomerTester {
    
	Customer c1;
	
	@BeforeEach
	public void before() {
		Customer c1 = new Customer(2000, "Ganesh", "ganesh@gmail.com", 22, "9637731476");
	}
	
	
	@AfterEach
	public void after() {
		c1=null;
	}
	
	@Test
	void testGetCustomerId() {
	assertEquals(2001, c1.getCustid());
		
	}

	@Test
	void testGetUsername() {
		assertEquals("Ganesh", c1.getUsername());
	}

	@Test
	void testGetCustomerEmail() {
		assertEquals("ganesh@gmail.com", c1.getEmail());
	}
	
	@Test
     void testGetCustomerContactNo() {
		assertEquals("9637731476",c1.getContactNo());
	}
	
	@Test
	void testGetCustomerAge() {
		assertEquals(22, c1.getAge());
	}

	
	
	
	@Test
	void testSetCustomerId() {
		c1.setCustid(111);
		assertEquals(101, c1.getCustid());
	}

	@Test
	void testSetCustomerUsername() {
		c1.setUsername("Ganesh");
		assertEquals("Ganesh", c1.getUsername());
	}

	@Test
	void testSetCustomerEmail() {
		c1.setEmail("ganesh@gmail.com");
		assertEquals("ganesh@gmail.com",c1.getEmail());
	}

	@Test
	void testSetCustomerContactNO() {
		c1.setContactNo("9637731476");
		assertEquals("9637731476",c1.getContactNo());
	}
	@Test
	void testSetCustomerAge() {
		c1.setAge(22);
		assertEquals(22, c1.getAge());
	}
	
	


}
