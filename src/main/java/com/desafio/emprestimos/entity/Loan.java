package com.desafio.emprestimos.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_loans")
public class Loan implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private LoanType type;
	
	@Column(nullable = false)
	private Integer interestRate;
	
	
	public Loan() {
	}

	public Loan(LoanType type, Integer interestRate) {
		super();
		this.type = type;
		this.interestRate = interestRate;
	}

	public LoanType getType() {
		return type;
	}

	public Integer getInterestRate() {
		return interestRate;
	}

	public void setType(LoanType type) {
		this.type = type;
	}

	public void setInterestRate(Integer interestRate) {
		this.interestRate = interestRate;
	}

	@Override
	public String toString() {
		return "Loan [type=" + type + ", interestRate=" + interestRate + "]";
	}
	
	

}
