package com.example.gisdashboard.service;

import com.example.gisdashboard.model.User;
import com.example.gisdashboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User saveUser(String username, String password) {
        String encoded = passwordEncoder.encode(password);
        User user = new User(username, encoded);
        return userRepository.save(user);
    }

    public boolean checkUser(String username, String password) {
        return userRepository.findByUsername(username)
                .map(u -> passwordEncoder.matches(password, u.getPassword()))
                .orElse(false);
    }
}
