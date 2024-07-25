package com.desafio.emprestimos.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_persons")
public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Integer age;
	
	@Column(unique = true,nullable = false)
	private String cpf;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private Double income;
	
	@Column(nullable = false)
	private String location;
	
	@OneToMany
	private Set<Loan> loans = new HashSet<>();
	
	public Person() {
	}

	public Person(Integer age, String cpf, String name, Double income, String location) {
		super();
		this.age = age;
		this.cpf = cpf;
		this.name = name;
		this.income = income;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public Integer getAge() {
		return age;
	}

	public String getCpf() {
		return cpf;
	}

	public String getName() {
		return name;
	}

	public Double getIncome() {
		return income;
	}

	public String getLocation() {
		return location;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Loan> getLoans() {
		return loans;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
