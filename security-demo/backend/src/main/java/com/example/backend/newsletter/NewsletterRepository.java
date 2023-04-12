package com.example.backend.newsletter;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NewsletterRepository extends CrudRepository<Newsletter, Long> {

    Optional<Newsletter> findByEmail(String email);
}
