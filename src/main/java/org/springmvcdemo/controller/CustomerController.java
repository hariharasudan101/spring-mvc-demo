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
import org.springmvcdemo.entity.Customer;
import org.springmvcdemo.service.CustomerService;
import org.springmvcdemo.util.LoginUser;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show customer-form handler method");
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		String account = LoginUser.getLoggedInUserName();
		if (account != null) {
			theModel.addAttribute("account", account);
		}
		return "customer-form";
	}

	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") @Valid Customer theCustomer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer-form";
		}

		customerService.saveCustomer(theCustomer);

		return "redirect:/home";
	}

}
