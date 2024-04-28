package com.test.safeway.dto;

import java.io.Serializable;
import java.util.Objects;

import com.test.safeway.models.Company;


public class CompanyDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private String name;

	private String cnpj;

	private String email;

	private Double withdrawalFee = 0.0;

	private Double depositFee = 0.0;
	
	public CompanyDTO() {}

	public CompanyDTO(String name, String cnpj, String email, Double withdrawalFee, Double depositFee) {
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
		this.withdrawalFee = withdrawalFee;
		this.depositFee = depositFee;
	}

	public CompanyDTO(Company entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cnpj = entity.getCnpj();
		this.email = entity.getEmail();
		this.withdrawalFee = entity.getWithdrawalFee();
		this.depositFee = entity.getDepositFee();
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
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		CompanyDTO that = (CompanyDTO) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(cnpj, that.cnpj) &&
				Objects.equals(email, that.email) &&
				Objects.equals(withdrawalFee, that.withdrawalFee) &&
				Objects.equals(depositFee, that.depositFee);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cnpj, email, withdrawalFee, depositFee);
	}

	@Override
	public String toString() {
		return "CompanyDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cnpj='" + cnpj + '\'' +
				", email='" + email + '\'' +
				", withdrawalFee=" + withdrawalFee +
				", depositFee=" + depositFee +
				'}';
	}
}
