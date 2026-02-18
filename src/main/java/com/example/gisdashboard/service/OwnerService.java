package com.example.gisdashboard.service;

import com.example.gisdashboard.model.Owner;
import com.example.gisdashboard.repository.OwnerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;
    private final PasswordEncoder passwordEncoder;

    public OwnerService(OwnerRepository ownerRepository, PasswordEncoder passwordEncoder) {
        this.ownerRepository = ownerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Register a new owner.
     * Password will be hashed using BCrypt.
     */
    public Owner registerOwner(Owner owner) {
        owner.setPassword(passwordEncoder.encode(owner.getPassword()));
        return ownerRepository.save(owner);
    }

    /**
     * Find owner by username (used for login).
     */
    public Optional<Owner> findByUsername(String username) {
        return Optional.ofNullable(ownerRepository.findByUsername(username));
    }

    /**
     * Verify password (for custom login, optional if using Spring Security).
     */
    public boolean checkPassword(Owner owner, String rawPassword) {
        return passwordEncoder.matches(rawPassword, owner.getPassword());
    }
}
