package org.springmvcdemo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springmvcdemo.entity.Customer;
import org.springmvcdemo.entity.CustomerProfile;
import org.springmvcdemo.exception.ResourceNotFoundException;
import org.springmvcdemo.repository.CustomerRepository;

@Service
public class CustomerService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerService.class);
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}

	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerRepository.save(theCustomer);
	}

	@Transactional
	public Customer getCustomer(int id) throws ResourceNotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@Transactional
	public Customer getCustomerByAccountNum(int accountNum) throws ResourceNotFoundException {
		return customerRepository.findByAccountNumber(accountNum)
				.orElseThrow(() -> new ResourceNotFoundException(accountNum));
	}

	@Transactional
	public CustomerProfile getCustomerProfileByAccountNum(int accountNum) throws ResourceNotFoundException {
		Customer customer = customerRepository.findByAccountNumber(accountNum)
				.orElseThrow(() -> new ResourceNotFoundException(accountNum));
		CustomerProfile customerProfile = customer.getCustomerProfile();
		LOG.info("Customer profile for the account " + accountNum + "is " + customerProfile);
		
		return customerProfile;
	}

}
