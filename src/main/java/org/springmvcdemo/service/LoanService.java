package org.springmvcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springmvcdemo.entity.Loan;
import org.springmvcdemo.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepository;

	@Transactional
	public List<Loan> getLoans() {
		return loanRepository.findAll();
	}

	@Transactional
	public void saveLoan(Loan loan) {
		loanRepository.save(loan);
	}

}
