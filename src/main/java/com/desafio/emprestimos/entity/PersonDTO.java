package com.desafio.emprestimos.entity;

import java.util.Set;

public record PersonDTO(String name,Set<Loan> loans) {

}
