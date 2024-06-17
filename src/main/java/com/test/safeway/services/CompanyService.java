package com.test.safeway.services;

import java.util.List;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.safeway.dtos.CompanyDTO;
import com.test.safeway.models.Company;
import com.test.safeway.repositories.CompanyRepository;
import com.test.safeway.services.exceptions.CompanyNotFoundException;

@Service
public class CompanyService {
	
	private final CompanyRepository companyRepository;
	
	@Autowired
	public CompanyService(CompanyRepository companyRepository) {

		this.companyRepository = companyRepository;
	}
	
	public List<Company> findAll() {
		return companyRepository.findAll();
	}
	
	public Company findById(Long id) {
		return companyRepository.findById(id)
				.orElseThrow(() -> new CompanyNotFoundException("Company not found"));
	}
	@Transactional
	public CompanyDTO create(CompanyDTO companyDTO) {
		Company create = new Company();
		create.setName(companyDTO.getName());
		create.setCnpj(companyDTO.getCnpj());
		create.setEmail(companyDTO.getEmail());
		create.setWithdrawalFee(companyDTO.getWithdrawalFee());
		create.setDepositFee(companyDTO.getDepositFee());
		create = companyRepository.save(create);
		return new CompanyDTO(create);
	}
	@Transactional
	public Company update(Long id, CompanyDTO companyDTO) {
		return companyRepository.findById(id).map(company -> {

			if(companyDTO.getName() != null) {
				company.setName(companyDTO.getName());
			}
			if(companyDTO.getCnpj() != null) {
				company.setCnpj(companyDTO.getCnpj());
			}
			if(companyDTO.getEmail() != null) {
				company.setEmail(companyDTO.getEmail());
			}
			if(companyDTO.getWithdrawalFee() != null) {
				company.setWithdrawalFee(companyDTO.getWithdrawalFee());
			}
			if(companyDTO.getDepositFee() != null) {
				company.setDepositFee(companyDTO.getDepositFee());
			}

			companyRepository.save(company);
			return company;
		}).orElseThrow(() -> new CompanyNotFoundException("Company not found"));
	}
	@Transactional
	public void delete(Long id) {
		companyRepository.findById(id).ifPresentOrElse(
				response -> companyRepository.deleteById(id),
				() -> {
					throw new CompanyNotFoundException("Company not found");
				}
		);
	}
}
