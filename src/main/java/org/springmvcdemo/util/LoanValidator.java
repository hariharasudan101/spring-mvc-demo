package org.springmvcdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springmvcdemo.entity.Customer;
import org.springmvcdemo.entity.Loan;
import org.springmvcdemo.exception.ResourceNotFoundException;
import org.springmvcdemo.service.CustomerService;

@Component
public class LoanValidator implements Validator {
	private static final Logger LOG = LoggerFactory.getLogger(LoanValidator.class);
	@Autowired
	CustomerService customerService;

	public boolean supports(Class clazz) {
		return Loan.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		if (target instanceof Loan) {
			Loan loan = (Loan) target;

			Customer customer;
			try {
				customer = customerService.getCustomerByAccountNum(loan.getAccountNumber());
				LOG.info("Customer applying the loan is " + customer);
				double salary = Double.parseDouble(customer.getSalary());
				long loanAmount = loan.getAmount();
				
				LOG.info("customet salary ::" + salary+ " loan amount ::"+ loanAmount);
				if (loanAmount > (salary + salary * 0.5)) {
					errors.rejectValue("amount", "greater","User is not eligible to apply the mentioned amount loan");
				}
			} catch (ResourceNotFoundException e) {
				errors.rejectValue("accountNumber",
						"invalid", "Unable to find the customer with account number "+loan.getAccountNumber());
			}

		}
	}

}