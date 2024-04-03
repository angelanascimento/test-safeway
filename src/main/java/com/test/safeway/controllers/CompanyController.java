package com.test.safeway.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.safeway.dto.CompanyDTO;
import com.test.safeway.models.Company;
import com.test.safeway.services.CompanyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	private final CompanyService companyService;
	
	@Autowired
	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getAll() {
		List<Company> companies = companyService.findAll();
		return ResponseEntity.ok(companies);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getById(@PathVariable Long id) {
		Company company = companyService.findById(id);
		return ResponseEntity.ok(company);
	}

	@PostMapping
	public ResponseEntity<CompanyDTO> create(@RequestBody CompanyDTO companyDTO) {
		companyDTO = companyService.create(companyDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(companyDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(companyDTO);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Company> update(@PathVariable Long id, @RequestBody CompanyDTO companyDTO) {
		Company company = companyService.update(id, companyDTO);
		return ResponseEntity.ok().body(company);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		companyService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
