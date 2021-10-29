package org.springmvcdemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springmvcdemo.entity.CustomerProfile;

@Component
public class CustomerProfileValidator implements Validator {
	private static final Logger LOG = LoggerFactory.getLogger(CustomerProfileValidator.class);
	
	public boolean supports(Class clazz) {
		return CustomerProfile.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "email", "required.email","Email is required");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "phone", "required.phone","Phone is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "addressLine1", "required.addressLine1","AddressLine1 is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "addressLine2", "required.addressLine2","AddressLine2 is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "city", "required.city","City is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "state", "required.state","State is required");
		ValidationUtils.rejectIfEmptyOrWhitespace(
	            errors, "zip", "required.zip","ZIP is required");
		
	}

}