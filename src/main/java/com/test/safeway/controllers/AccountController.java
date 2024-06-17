package com.test.safeway.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.safeway.dtos.AccountDTO;
import com.test.safeway.models.Account;
import com.test.safeway.services.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
private final AccountService accountService;
	
	@Autowired
	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}
	
	@GetMapping
	public ResponseEntity<List<Account>> getAll() {
		List<Account> accounts = accountService.findAll();
		return ResponseEntity.ok(accounts);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Account> getById(@Valid @PathVariable Long id) {
		Account account = accountService.findById(id);
		return ResponseEntity.ok(account);
	}

	@PostMapping
	public ResponseEntity<Account> create(@RequestBody AccountDTO accountDTO) {
		Account account = accountService.create(accountDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(accountDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(account);
	}

	@PutMapping("/withdraw/{id}")
	public ResponseEntity<String> withdraw(@PathVariable Long id, Double value) {
		String account = accountService.withdraw(id, value);

		return ResponseEntity.ok(account);
	}

	@PutMapping("deposit/{id}")
	public ResponseEntity<String> depositFee(@PathVariable Long id, Double value) {
		String account = accountService.depositFee(id, value);

		return ResponseEntity.ok(account);
	}

}
