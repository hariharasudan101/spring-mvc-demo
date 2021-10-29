package org.springmvcdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springmvcdemo.entity.CustomerProfile;
import org.springmvcdemo.repository.CustomerProfileRepository;

@Service
public class CustomerProfileService {

	@Autowired
	private CustomerProfileRepository customerProfileRepository;

	@Transactional
	public void saveCustomerProfile(CustomerProfile customerProfile) {
		customerProfileRepository.save(customerProfile);
	}

}
