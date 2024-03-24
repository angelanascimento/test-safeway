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
	
	public CompanyDTO() {}

	public CompanyDTO(String name, String cnpj, String email) {
		this.name = name;
		this.cnpj = cnpj;
		this.email = email;
	}

	public CompanyDTO(Company entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cnpj = entity.getCnpj();
		this.email = entity.getEmail();
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

	@Override
	public int hashCode() {
		return Objects.hash(cnpj, email, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompanyDTO other = (CompanyDTO) obj;
		return Objects.equals(cnpj, other.cnpj) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "CompanyDTO [id=" + id + ", "
				+ "name=" + name + ", "
				+ "cnpj=" + cnpj + ", "
				+ "email=" + email + "]";
	}
	
	
}
