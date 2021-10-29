package org.springmvcdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springmvcdemo.entity.Loan;

@Repository("loanRepository")
public interface LoanRepository extends JpaRepository<Loan, Integer> {

}