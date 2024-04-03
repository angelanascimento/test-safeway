package com.test.safeway.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.safeway.models.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
