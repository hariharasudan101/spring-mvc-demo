package org.springmvcdemo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springmvcdemo.entity.Customer;
import org.springmvcdemo.entity.CustomerProfile;
import org.springmvcdemo.exception.ResourceNotFoundException;
import org.springmvcdemo.service.CustomerService;
import org.springmvcdemo.util.CustomerProfileValidator;

@Controller
@RequestMapping("/customer-profile")
public class CustomerProfileController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerProfileController.class);

	@Autowired
	CustomerProfileValidator customerProfileValidator;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/showForm")
	public String showFormForUpdate(@RequestParam("account") int account, Model theModel)
			throws ResourceNotFoundException {
		CustomerProfile customerProfile = customerService.getCustomerProfileByAccountNum(account);


		if (customerProfile == null) {
			customerProfile = new CustomerProfile();
		}

		theModel.addAttribute("customerProfile", customerProfile);
		theModel.addAttribute("account", account);

		return "customer-profile";
	}

	@PostMapping("/saveCustomerProfile")
	public String saveCustomerProfile(@RequestParam("account") int account,
			@ModelAttribute("customerProfile") @Valid CustomerProfile customerProfile, BindingResult bindingResult, Model model)
			throws ResourceNotFoundException {
		customerProfileValidator.validate(customerProfile, bindingResult);
		LOG.info("Error Count: "+bindingResult.getErrorCount()+ bindingResult.hasErrors());
		LOG.info("Customer Profile "+ customerProfile);
		model.addAttribute("customerProfile", customerProfile);
		model.addAttribute("account", account);
		if (bindingResult.hasErrors()) {
			return "customer-profile";
		}
		Customer customer = customerService.getCustomerByAccountNum(account);
		customer.setCustomerProfile(customerProfile);
		customerService.saveCustomer(customer);
//		customerProfileService.saveCustomerProfile(customerProfile);

		return "redirect:/home";
	}

}
