package com.test.safeway.dtos;

import java.io.Serializable;
import java.util.Objects;

import com.test.safeway.models.Customer;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	private String email;
	
	CustomerDTO() {}

	public CustomerDTO(String name, String cpf, String email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public CustomerDTO(Customer entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
		this.email = entity.getEmail();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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
		CustomerDTO that = (CustomerDTO) o;
		return Objects.equals(id, that.id) &&
				Objects.equals(name, that.name) &&
				Objects.equals(cpf, that.cpf) &&
				Objects.equals(email, that.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, cpf, email);
	}

	@Override
	public String toString() {
		return "CustomerDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", cpf='" + cpf + '\'' +
				", email=" + email +
				'}';
	}
}
