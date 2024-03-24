package com.test.safeway.models;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.hibernate.validator.constraints.br.CNPJ;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_companies")
public class Company implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	private String name;
	
	@Column(unique = true)
	@NotBlank
	@CNPJ
	private String cnpj;
	
	@NotBlank
	@Email
	private String email;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "companiesId", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("companiesId")
	private List<Account> accounts;
	
	private Double balance;
	private Double withdrawalFee;
	private Double depositFee;
	
	public Company() {}

	public Company(@NotBlank String name, @NotBlank @CNPJ String cnpj, @NotBlank @Email String email,
			List<Account> accounts, Double balance, Double withdrawalFee, Double depositFee) {
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
		this.accounts = accounts;
		this.balance = balance;
		this.withdrawalFee = withdrawalFee;
		this.depositFee = depositFee;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawalFee() {
		return withdrawalFee;
	}

	public void setWithdrawalFee(Double withdrawalFee) {
		this.withdrawalFee = withdrawalFee;
	}

	public Double getDepositFee() {
		return depositFee;
	}

	public void setDepositFee(Double depositFee) {
		this.depositFee = depositFee;
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
		Company other = (Company) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", "
				+ "name=" + name + ", "
				+ "cnpj=" + cnpj + ", "
				+ "email=" + email + ", "
				+ "balance=" + balance + ", "
				+ "withdrawalFee=" + withdrawalFee + ", "
				+ "depositFee=" + depositFee + "]";
	}
}
