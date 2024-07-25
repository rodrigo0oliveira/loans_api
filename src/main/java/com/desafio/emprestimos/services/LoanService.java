package com.desafio.emprestimos.services;

import org.springframework.stereotype.Service;

import com.desafio.emprestimos.entity.Loan;
import com.desafio.emprestimos.entity.LoanType;
import com.desafio.emprestimos.entity.Person;
import com.desafio.emprestimos.entity.PersonDTO;

@Service
public class LoanService {
	
	public PersonDTO loan(Person person) {
		
		verifyIfLoanIspersonal(person);
		verifyIfLoanIsGuaranteed(person);
		verifyIfLoanIsConsignment(person);
		
		PersonDTO dto = new PersonDTO(person.getName(),person.getLoans());
		
		return dto;
		
	}
	
	
	
	
	private void verifyIfLoanIspersonal(Person person) {
		Loan loan = new Loan(LoanType.PERSONAL,4);
		if(person.getIncome()<=3000.00) {
			person.getLoans().add(loan);
		}
		else if(person.getIncome()>=3000&&person.getIncome()<=5000
				&&person.getAge()<30
				&&person.getLocation().equals("SP")) {
			person.getLoans().add(loan);
		}
	}
	
	private void verifyIfLoanIsGuaranteed(Person person) {
		Loan loan = new Loan(LoanType.GUARANTEED,3);
		if(person.getIncome()<=3000.00) {
			person.getLoans().add(loan);
		}
		else if(person.getIncome()>=3000&&person.getIncome()<=5000
				&&person.getAge()<30
				&&person.getLocation().equals("SP")) {
			person.getLoans().add(loan);
		}
	}
	
	private void verifyIfLoanIsConsignment(Person person) {
		Loan loan = new Loan(LoanType.CONSIGNMENT,3);
		if(person.getIncome()>=5000.00) {
			person.getLoans().add(loan);
		}
	}

}
