package com.test.safeway.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.br.CPF;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_customers")
public class Customer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Column(unique = true)
	@NotBlank
	@CPF
	private String cpf;

	@Column(unique = true)
	@NotBlank
	@Email
	private String email;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customersId", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("customersId")
	private List<Account> accounts;
	

	
	public Customer() {}

	public Customer(@NotBlank String name, @NotBlank @CPF String cpf, List<Account> accounts, String email) {
		this.name = name;
		this.cpf = cpf;
		this.accounts = accounts;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id) &&
				Objects.equals(name, customer.name) &&
				Objects.equals(cpf, customer.cpf) &&
				Objects.equals(email, customer.email) &&
				Objects.equals(accounts, customer.accounts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cpf, email, accounts);
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cpf='" + cpf + '\'' +
				", email=" + email +
				", accounts=" + accounts +
				'}';
	}
}
