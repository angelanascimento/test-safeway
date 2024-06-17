package com.test.safeway.repositories;

import com.test.safeway.models.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {


}
