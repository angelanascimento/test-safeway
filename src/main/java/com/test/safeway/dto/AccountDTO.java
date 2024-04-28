package com.test.safeway.dto;

import java.io.Serializable;
import java.util.Objects;

import com.test.safeway.models.Account;
import com.test.safeway.models.Company;
import com.test.safeway.models.Customer;

public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Company companiesId;
	private Customer customersId;
	private Double balance;
	
	public AccountDTO() {}

	public AccountDTO(Company companiesId, Customer customersId,Double balance ) {
		this.companiesId = companiesId;
		this.customersId = customersId;
		this.balance = balance;
	}
	
	public AccountDTO(Account account) {
		this.companiesId = account.getCompaniesId();
		this.customersId = account.getCustomersId();
		this.balance = account.getBalance();

	}

	public Long getId() {
		return id;
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
		AccountDTO that = (AccountDTO) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(companiesId, that.companiesId) &&
				Objects.equals(customersId, that.customersId) &&
				Objects.equals(balance, that.balance);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, companiesId, customersId, balance);
	}

	@Override
	public String toString() {
		return "AccountDTO{" +
				"id=" + id +
				", companiesId=" + companiesId +
				", customersId=" + customersId +
				", balance=" + balance +
				'}';
	}
}
