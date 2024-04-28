package com.test.safeway.models;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_accounts")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@ManyToOne
    @JsonIgnoreProperties("accounts")
	private Company companiesId;
	
	@NotNull
	@ManyToOne
    @JsonIgnoreProperties("accounts")
	private Customer customersId;

	private Double balance = 0.0;
	
	public Account() {}

	public Account(Long id, @NotNull Company companiesId, @NotNull Customer customersId, Double balance) {
		this.id = id;
		this.companiesId = companiesId;
		this.customersId = customersId;
		this.balance = balance;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Company getCompaniesId() {
		return companiesId;
	}

	public void setCompaniesId(Company companiesId) {
		this.companiesId = companiesId;
	}

	public Customer getCustomersId() {
		return customersId;
	}

	public void setCustomersId(Customer customersId) {
		this.customersId = customersId;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return Objects.equals(id, account.id) &&
				Objects.equals(companiesId, account.companiesId) &&
				Objects.equals(customersId, account.customersId) &&
				Objects.equals(balance, account.balance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, companiesId, customersId, balance);
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", companiesId=" + companiesId +
				", customersId=" + customersId +
				", balance=" + balance +
				'}';
	}
}
