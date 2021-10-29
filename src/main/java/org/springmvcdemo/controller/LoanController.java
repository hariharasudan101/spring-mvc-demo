package org.springmvcdemo.controller;

import java.sql.Date;
import java.util.List;

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
import org.springmvcdemo.entity.Loan;
import org.springmvcdemo.exception.ResourceNotFoundException;
import org.springmvcdemo.service.CustomerService;
import org.springmvcdemo.service.LoanService;
import org.springmvcdemo.util.LoanValidator;
import org.springmvcdemo.util.LoginUser;

@Controller
@RequestMapping("/loan")
public class LoanController {

	private static final Logger LOG = LoggerFactory.getLogger(LoanController.class);

	@Autowired
	private LoanService loanService;

	@Autowired
	LoanValidator loanValidator;

	@Autowired
	private CustomerService customerService;

	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		LOG.debug("inside show loan-form handler method");

		Loan loan = new Loan();
		String acctNum = LoginUser.getLoggedInUserName();
		if (!"admin".equalsIgnoreCase(acctNum)) {
			int account = Integer.parseInt(acctNum);
			loan.setAccountNumber(account);
			theModel.addAttribute("account", account);
		}
		theModel.addAttribute("loan", loan);
		return "loan-form";
	}

	@GetMapping("/listLoan")
	public String listLoan(Model theModel) {
		LOG.debug("inside list load handler method");
		List<Loan> loans = loanService.getLoans();
		theModel.addAttribute("loans", loans);
		String account = LoginUser.getLoggedInUserName();
		if (account != null) {
			theModel.addAttribute("account", account);
		}
		return "list-loan";
	}

	@PostMapping("/saveLoan")
	public String saveLoan(@ModelAttribute("loan") @Valid Loan loan, BindingResult bindingResult) {

		LOG.info("Error Count: " + bindingResult.getErrorCount() + bindingResult.hasErrors());
		LOG.info("Loan " + loan);
		loanValidator.validate(loan, bindingResult);
		if (bindingResult.hasErrors()) {
			return "loan-form";
		}

		try {
			Customer customer = customerService.getCustomerByAccountNum(loan.getAccountNumber());
			loan.setCustomer(customer);
		} catch (ResourceNotFoundException e) {
			LOG.error("Unable to find the customer");

		}
		loan.setBookedDate(new Date(System.currentTimeMillis()));
		loanService.saveLoan(loan);
		return "redirect:/home";
	}

	/*
	 * @ExceptionHandler(value = {BindException.class,
	 * ResourceNotFoundException.class}) public String
	 * handleError(HttpServletRequest req, Exception exception) {
	 * LOG.error("Error occured while accessing the request: " +
	 * req.getRequestURL(), exception); return "loan-form"; }
	 */

}
