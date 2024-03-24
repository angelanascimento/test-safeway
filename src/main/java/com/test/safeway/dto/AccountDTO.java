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
	
	AccountDTO() {}

	public AccountDTO(Company companiesId, Customer customersId) {
		this.companiesId = companiesId;
		this.customersId = customersId;
	}
	
	public AccountDTO(Account account) {
		this.companiesId = account.getCompaniesId();
		this.customersId = account.getCustomersId();
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

	@Override
	public int hashCode() {
		return Objects.hash(companiesId, customersId, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountDTO other = (AccountDTO) obj;
		return Objects.equals(companiesId, other.companiesId) && Objects.equals(customersId, other.customersId)
				&& Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "AccountDTO [id=" + id + ", "
				+ "companiesId=" + companiesId + ", "
				+ "customersId=" + customersId + "]";
	}

}
