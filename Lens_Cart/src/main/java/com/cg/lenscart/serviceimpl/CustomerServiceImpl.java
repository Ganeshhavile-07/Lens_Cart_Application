package com.cg.lenscart.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.lenscart.entity.Customer;
import com.cg.lenscart.exception.CustomerNotFoundException;
import com.cg.lenscart.exception.NoProperDataException;
import com.cg.lenscart.repository.CustomerRepository;
import com.cg.lenscart.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public ResponseEntity<List<Customer>> getAllCustomers() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all customers from here");
		return new  ResponseEntity<>(customerRepository.findAll(),HttpStatus.OK);
	
	}

	@Override
	public ResponseEntity<Customer> getCustomerById(int id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer customers=customerRepository.findById(id).orElseThrow(()-> new  CustomerNotFoundException("customer Not Found"+id));

		return ResponseEntity.ok().body(customers);
	}

	@Override
	public ResponseEntity<Customer> addCustomer(Customer customer) throws NoProperDataException {
		// TODO Auto-generated method stub
		log.info("start");
		if(customer!=null) 
		{
			customerRepository.save(customer);
			System.out.println("customer added");
		}
		else
		{
			throw new NoProperDataException("Please fill fields");
		}
		return ResponseEntity.ok(customer);
	}

	@Override
	public ResponseEntity<Customer> updateCustomer(Customer customer, int id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
Customer customers=customerRepository.findById(id).orElseThrow(()-> new CustomerNotFoundException("seed not "+id));
		
		customers.setUsername(customer.getUsername());
		customers.setAge(customer.getAge());
		customers.setEmail(customer.getEmail());
		customers.setContact_No(customer.getContact_No());
		
		
		final Customer updatedCustomer = customerRepository.save(customer);
		return ResponseEntity.ok(updatedCustomer);
	}
	
//	@Override
//	public ResponseEntity<Customer> deleteCustomer(Plant id) throws CustomerNotFoundException {
//		log.info("Start delete");
//		var isRemoved =customerRepository.findById(id);
//		if(isRemoved.isPresent())
//		{
//			customerRepository.delete(id);
//			log.debug("deleted successfully {}",isRemoved.get());
//		}
//		else
//		{
//			throw new CustomerNotFoundException("Id Not Available");
//		}
//		log.info(" deleted End");
//		return new ResponseEntity<>(id,HttpStatus.OK);
//	}


}
