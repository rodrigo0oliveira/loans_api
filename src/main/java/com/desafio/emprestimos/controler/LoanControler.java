package com.desafio.emprestimos.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.emprestimos.entity.Person;
import com.desafio.emprestimos.entity.PersonDTO;
import com.desafio.emprestimos.services.LoanService;

@RestController
@RequestMapping("/api")
public class LoanControler {
	
	@Autowired
	private LoanService loanService;
	
	@PostMapping("/customer-loans")
	public ResponseEntity<PersonDTO> loan(@RequestBody Person person){
		PersonDTO dto = loanService.loan(person);
		return ResponseEntity.ok().body(dto);
	}

}
