package com.test.safeway.dto;

import java.io.Serializable;
import java.util.Objects;

import com.test.safeway.models.Customer;

public class CustomerDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String cpf;
	
	CustomerDTO() {}

	public CustomerDTO(String name, String cpf) {
		this.name = name;
		this.cpf = cpf;
	}

	public CustomerDTO(Customer entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.cpf = entity.getCpf();
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "CustormerDTO [id=" + id + ", "
				+ "name=" + name + ", "
				+ "cpf=" + cpf + "]";
	}
}
