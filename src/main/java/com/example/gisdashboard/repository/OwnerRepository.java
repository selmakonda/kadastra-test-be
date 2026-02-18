package com.example.gisdashboard.repository;

import com.example.gisdashboard.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Owner findByUsername(String username);
}
