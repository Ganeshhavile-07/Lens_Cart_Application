package com.cg.cs.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.cs.entity.Customer;
import com.cg.cs.exception.CustomerNotFoundException;
import com.cg.cs.exception.NoProperDataException;
import com.cg.cs.repository.CustomerRepository;
import com.cg.cs.service.CustomerService;
import lombok.extern.slf4j.Slf4j;

//@Service means the class consist of all business related logic
@Service
@Slf4j
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override // =>user/admin
	public List<Customer> getAllCustomers() throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		log.info("get all customers  from here");
		if (customerRepository.findAll().isEmpty()) {
			throw new CustomerNotFoundException("No Customer Found");
		} else {
			return customerRepository.findAll();
		}
		// new ResponseEntity<>(productrepository.findAll(),HttpStatus.OK);
	}

	@Override
	public Customer addCustomer(Customer customer) throws NoProperDataException {
		// TODO Auto-generated method stub
		Customer bean = customerRepository.save(customer);
		if (bean == null) {
			throw new NoProperDataException("Please fill fields");
		}
		return bean;
	}

	@Override
	public Customer updateCustomer(Customer customer, Long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		log.info("update");
		Customer cust = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("No customer Availble wth this id"));
		cust.setUsername(customer.getUsername());
		cust.setEmail(customer.getEmail());
		cust.setAge(customer.getAge());
		cust.setContact_No(customer.getContact_No());

		final Customer updatedcustomer = customerRepository.save(cust);
		return updatedcustomer;
		// ResponseEntity.ok(updatedProduct);
	}
     
	@Override
	public String deleteCustomer(Long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		
		var isRemoved = customerRepository.findById(id);
		log.debug("delete started {}",isRemoved);
		if (isRemoved.isPresent()) {
			customerRepository.deleteById(id);
			log.debug("deleted succesfully {}", isRemoved.get());
		} else {
			throw new CustomerNotFoundException("customer not available to delete on given id");
		}
		log.info("end");
		return "deleted";
	}

	@Override
	public Customer getCustomerById(Long id) throws CustomerNotFoundException {
		// TODO Auto-generated method stub
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("User Not Found with id " + id));
		return customer;
		// ResponseEntity.ok().body(lo);
		// getById id takes only id has input (it will not take object Product product)

	}

}
