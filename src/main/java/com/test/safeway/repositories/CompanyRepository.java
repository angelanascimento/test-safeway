package com.test.safeway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.safeway.dto.CompanyDTO;
import com.test.safeway.models.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {


}
