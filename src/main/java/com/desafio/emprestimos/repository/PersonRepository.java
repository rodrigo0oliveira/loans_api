package com.desafio.emprestimos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.emprestimos.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

}
