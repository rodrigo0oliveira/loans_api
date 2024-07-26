package com.desafio.emprestimos.services;

import org.springframework.stereotype.Service;

import com.desafio.emprestimos.entity.Loan;
import com.desafio.emprestimos.entity.LoanType;
import com.desafio.emprestimos.entity.Person;
import com.desafio.emprestimos.entity.PersonDTO;

@Service
public class LoanService {
	
	public PersonDTO loan(Person person) {
	
		verifyIfPersonCanGetAPersonalLoan(person);
		verifyIfPersonCanGetAGuaranteedLoan(person);
		verifyIfPersonCanGetAConsignmentLoan(person);
		
		PersonDTO dto = new PersonDTO(person.getName(),person.getLoans());
		
		return dto;
		
	}	
	
	public void verifyIfPersonCanGetAPersonalLoan(Person person) {
		Loan loan = new Loan(LoanType.PERSONAL,4);
		if(person.getIncome()<=3000.00) {
			person.getLoans().add(loan);
		}
		else if(person.getIncome()>=3000&&person.getIncome()<=5000
				||person.getAge()<30
				&&person.getLocation().equals("SP")) {
			person.getLoans().add(loan);
		}
	}
	
	public void verifyIfPersonCanGetAGuaranteedLoan(Person person) {
		Loan loan = new Loan(LoanType.GUARANTEED,3);
		if(person.getIncome()<=3000.00) {
			person.getLoans().add(loan);
		}
		else if(person.getIncome()>=3000&&person.getIncome()<=5000
				||person.getAge()<30
				&&person.getLocation().equals("SP")) {
			person.getLoans().add(loan);
		}
	}
	
	private void verifyIfPersonCanGetAConsignmentLoan(Person person) {
		Loan loan = new Loan(LoanType.CONSIGNMENT,2);
		if(person.getIncome()>=5000.00) {
			person.getLoans().add(loan);
		}
	}

}
