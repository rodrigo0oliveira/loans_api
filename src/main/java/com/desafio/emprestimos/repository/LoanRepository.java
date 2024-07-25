package com.desafio.emprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.emprestimos.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{

}
