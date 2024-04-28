package com.test.safeway.services;

import java.util.List;
import java.util.Optional;

import com.test.safeway.models.Company;
import com.test.safeway.models.Customer;
import com.test.safeway.repositories.CompanyRepository;
import com.test.safeway.repositories.CustomerRepository;
import com.test.safeway.services.exceptions.AccountNotFoundException;
import com.test.safeway.services.exceptions.InsufficientFundsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.safeway.dto.AccountDTO;
import com.test.safeway.models.Account;
import com.test.safeway.repositories.AccountRepository;

@Service
public class AccountService {

	private final AccountRepository accountRepository;
	private final CompanyRepository companyRepository;
	private final CustomerRepository customerRepository;
	
	@Autowired
	public AccountService(AccountRepository accountRepository, CompanyRepository companyRepository, CustomerRepository customerRepository) {
		this.accountRepository = accountRepository;
        this.companyRepository = companyRepository;
        this.customerRepository = customerRepository;
    }
	
	public List<Account> findAll() {
		return accountRepository.findAll();
	}
	
	public Account findById(Long id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new AccountNotFoundException("Company not found"));
	}
	@Transactional
	public Account create(AccountDTO accountDTO) {
		Account create = new Account();
		create.setCompaniesId(accountDTO.getCompaniesId());
		create.setCustomersId(accountDTO.getCustomersId());
		create = accountRepository.save(create);
		return create;
	}

	@Transactional
	public Account update(Long id, Account account) {
		return accountRepository.findById(id).map(accountResp -> {
			if(account.getBalance() != null) {
				account.setBalance(account.getBalance());
			}
			accountRepository.save(accountResp);
			return accountResp;
		}).orElseThrow(() -> new AccountNotFoundException("Account not found"));
	}
	@Transactional
	public String withdraw(Long accountId, Double value) {

		Optional<Account> account = accountRepository.findById(accountId);
		Company company = account.get().getCompaniesId();
		Customer customer = account.get().getCustomersId();
		Double withdrawalFee = (value * company.getWithdrawalFee() / 100);

		if(account.isEmpty()) {
			throw new AccountNotFoundException("ID não encontrado");
		}

		if(company.getBalance() < value) {
			throw new InsufficientFundsException("Saldo Insuficiente");
		}

		company.setBalance(company.getBalance() - value);
		companyRepository.save(company);
		account.get().setBalance(account.get().getBalance()- value - withdrawalFee);
		update(accountId, account.get());

		return "Saque Realizado com Sucesso!";
    }
	@Transactional
	public String depositFee(Long accountId, Double value) {

		Optional<Account> account = accountRepository.findById(accountId);
		Company company = account.get().getCompaniesId();

		if(account.isEmpty()) {
			throw new AccountNotFoundException("ID não encontrado");
		}

		company.setBalance(company.getBalance() + value);
		companyRepository.save(company);
		account.get().setBalance(account.get().getBalance() + value);
		update(accountId, account.get());

		return "Deposito Realizado com Sucesso!";
	}
}
