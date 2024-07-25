package com.desafio.emprestimos.entity;

import java.io.Serializable;

public enum LoanType implements Serializable{
	
	PERSONAL("PERSONAL"),
	GUARANTEED("GUARANTEED"),
	CONSIGNMENT("CONSIGNMENT");
	
	public String name;
	
	LoanType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
}
