package com.desafio.emprestimos;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.desafio.emprestimos.entity.Loan;
import com.desafio.emprestimos.entity.LoanType;
import com.desafio.emprestimos.entity.Person;
import com.desafio.emprestimos.services.LoanService;

@SpringBootTest
class EmprestimosApplicationTests {
	
	@Autowired
	LoanService loanService;
	
	Person person;
	
	@DisplayName("Method PersonalLoan Should Add A Type PersonalLoan in List of Loans")
	@Test
	void TestMethodVerifyIfPersonCanReceivePersonalLoanShouldAddPersonalLoan() {
		
		//Given
		person = new Person(15,"133.321.123-11","Rodrigo",3000.00,"PE");
		Loan expected = new Loan(LoanType.PERSONAL,4);
		
		//When
		loanService.verifyIfPersonCanGetAPersonalLoan(person);
		Set<Loan> actual = person.getLoans();
		
		//Then
		Assertions.assertNotNull(actual);
		assertThat(actual.toString()).contains(expected.toString());
		
	}
	
	@DisplayName("Method GuaranteedlLoan Should Add A Type GuaranteedLoan in List of Loans")
	@Test
	void TestMethodVerifyIfPersonCanReceiveGuaranteedLoanShouldAddGuaranteedLoan() {
		//Given
		person = new Person(23,"123-321-345-20","Lucas",6000.00,"SP");
		Loan expected = new Loan(LoanType.GUARANTEED,3);
		
		//When
		loanService.verifyIfPersonCanGetAGuaranteedLoan(person);
		Set<Loan> actual = person.getLoans();
		
		//Then
		Assertions.assertNotNull(actual);
		assertThat(actual.toString()).contains(expected.toString());
	}
	
	@Test
	void TestMethodVerifyIfPersonCanReceiveConsignmentLoanShouldAddConsignmentLoan() {
		//Given
		person = new Person(60,"123-321-345-20","Oliveira",16000.00,"PB");
		Loan expected = new Loan(LoanType.CONSIGNMENT,2);
				
		//When
		loanService.verifyIfPersonCanGetAConsignmentLoan(person);
		Set<Loan> actual = person.getLoans();
				
		//Then
		Assertions.assertNotNull(actual);
		assertThat(actual.toString()).contains(expected.toString());
	}
	
	

}
