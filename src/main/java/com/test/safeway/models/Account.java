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
	
	public Account() {}

	public Account(Long id, @NotNull Company companiesId, @NotNull Customer customersId) {
		this.id = id;
		this.companiesId = companiesId;
		this.customersId = customersId;
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
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", "
				+ "companiesId=" + companiesId + ", "
				+ "customersId=" + customersId + "]";
	}
}
