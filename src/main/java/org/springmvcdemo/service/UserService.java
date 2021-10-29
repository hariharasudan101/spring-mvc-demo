package org.springmvcdemo.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springmvcdemo.controller.CustomerController;
import org.springmvcdemo.entity.Customer;
import org.springmvcdemo.repository.CustomerRepository;

@Service
public class UserService implements UserDetailsService {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		if ("admin".equalsIgnoreCase(username)) {
			Set<GrantedAuthority> roles = new HashSet<>();
			roles.add(new SimpleGrantedAuthority("ADMIN"));

			List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
			return new org.springframework.security.core.userdetails.User("admin", "admin", grantedAuthorities);
		}

		int accountNum = Integer.parseInt(username);

		Optional<Customer> customer = customerRepository.findByAccountNumber(accountNum);

		if (customer.isPresent()) {
			LOG.info("User is found for given account number" + username);
			Set<GrantedAuthority> roles = new HashSet<>();
			roles.add(new SimpleGrantedAuthority("USER"));

			List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
			return new org.springframework.security.core.userdetails.User(
					String.valueOf(customer.get().getAccountNumber()), customer.get().getPassword(),
					grantedAuthorities);
		} else {
			LOG.error("Unable to find user for given account number" + username);
		}

		return null;
	}

}
