package com.cg.cs.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.cs.entity.Customer;
import com.cg.cs.exception.CustomerNotFoundException;
import com.cg.cs.exception.NoProperDataException;
import com.cg.cs.repository.CustomerRepository;
import com.cg.cs.serviceimpl.CustomerServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerServiceTest {
	

	private static final Object p1 = null;

	@InjectMocks
	private CustomerServiceImpl customerServiceImpl;
	
	@Mock
	private CustomerRepository customerRepository;
	
	@Test
	void testServiceNotNull() {
		assertThat(customerServiceImpl).isNotNull();
	}
	
	@Test
	void testRepositoryNotNull() {
		assertThat(customerRepository).isNotNull();
	}
	
	@Test
	void testGetAllCustomers() throws CustomerNotFoundException {
		Customer c1=new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
		Customer c2=new Customer(2001,"Saurabh","saurabh@gmail.com",23,"7865678998");
		
		List<Customer> customerlist=new ArrayList<Customer>();
		customerlist.add(c1);
		customerlist.add(c2);
		when(customerRepository.findAll()).thenReturn(customerlist);
		assertEquals(customerlist,customerServiceImpl.getAllCustomers());
		
	}
	
	@Test
	void testGetCustomerById() throws CustomerNotFoundException {
		Customer c1= new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
		when(customerRepository.findById((long) 101)).thenReturn(Optional.of(c1));
		assertEquals(c1,customerServiceImpl.getCustomerById((long) 101));
	}
	
	@Test
	void testGetCustomerByInvalidId() throws CustomerNotFoundException {
		Customer c1= new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
		when(customerRepository.findById((long) 101)).thenReturn(Optional.of(c1));
		try {
			assertThat(customerServiceImpl.getCustomerById((long) 1)).as("Customer with the id 1 doesn't exist");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	void testAddCustomerException() throws CustomerNotFoundException, NoProperDataException {
		Customer c1= null;//new Planter(2000,9, "red","oval",10, 90);
//		((List<Planter>) assertThat(planterServiceImpl.addPlanter(p1)))
//		.contains("added successfully....");
	    try {
	    	customerServiceImpl.addCustomer(c1);
	    }catch (Exception e) {
			// TODO: handle exception
	    	assertEquals("please fill field", e.getMessage());
		}
	}	
	
	@Test
	void testAddCustomer() throws CustomerNotFoundException, NoProperDataException {
		Customer c1= new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
		when(customerRepository.findById((long) 2000)).thenReturn(Optional.of(c1));
		((List<Customer>) assertThat(customerServiceImpl.addCustomer(c1)))
		.contains("added successfully....");
	
	}
	
	//@SuppressWarnings({ "unchecked", "unlikely-arg-type" })
	@Test
	void testAddCustomerAlreadyExists() throws CustomerNotFoundException {
		Customer c1= new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");
		when(customerRepository.findById((long) 101)).thenReturn(Optional.of(c1));
	try {
		((List<Customer>) assertThat(customerServiceImpl.addCustomer(c1)))
		.contains("Product with the id "+c1.getCustid()+" already exist");
	}catch(Exception e) {
		
	}
	}
//	
//	@Test
//	void testupdateCustomer() throws CustomerNotFoundException {
//		Customer c1= new Customer(2000,"Ganesh","ganesh@gmail.com",22,"9637731476");	
//		when(customerRepository.findById(101)).thenReturn(Optional.of(p1));
//		assertThat(customerServiceImpl.updateCustomer(c1))
//		.contains("updated successfully....");
//	
//	}
//	
//	@Test
//	void testupdatePlanterDoesnotExists() throws PlanterNotFoundException {
//		Planter p1= new Planter(2000,9, "red","oval",10, 90);	
//		when(planterRepository.findById(10)).thenReturn(Optional.of(p1));
//	try {
//		assertThat(planterServiceImpl.updatePlanter(p1))
//		.contains("Planter with the id "+p1.getPlanterId()+" doesn't exist for update");
//	}catch(Exception e) {
//		
//	}
//	}
	
	@Test
	void testDeleteCustomerById() throws CustomerNotFoundException {
		Customer c1= new Customer( 2000,"Ganesh","ganesh@gmail.com",22,"9637731476");

		when(customerRepository.findById((long) 10)).thenReturn(Optional.of(c1));
		assertThat(customerServiceImpl.deleteCustomer( (long) 101))
		.contains("deleted successfully....");
	}
	
	@Test
	void testDeleteCustomerByInvalidId() throws CustomerNotFoundException {
		Customer c1= new Customer( 2000,"Ganesh","ganesh@gmail.com",22,"9637731476");

		when(customerRepository.findById((long) 10)).thenReturn(Optional.of(c1));
		try {
			assertThat(customerServiceImpl.deleteCustomer((long) 111))
			.contains("Planter with the id "+c1.getCustid()+" doesn't exist");
		}catch(Exception e) {
			
		}
	}
	
	
	}