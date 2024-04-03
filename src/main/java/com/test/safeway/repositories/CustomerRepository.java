package com.test.safeway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.safeway.models.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
