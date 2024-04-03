package com.test.safeway.services;

import java.util.List;

import com.test.safeway.services.exceptions.AccountNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.safeway.dto.AccountDTO;
import com.test.safeway.models.Account;
import com.test.safeway.repositories.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
	
	public Account findById(Long id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Company not found"));
	}
	@Transactional
	public AccountDTO create(AccountDTO accountDTO) {
		Account create = new Account();
		create.setCompaniesId(accountDTO.getCompaniesId());
		create.setCustomersId(accountDTO.getCustomersId());
		create = accountRepository.save(create);
		return new AccountDTO(create);
	}

}
