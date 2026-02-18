package com.example.gisdashboard.controller;

import com.example.gisdashboard.model.Owner;
import com.example.gisdashboard.service.OwnerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final OwnerService ownerService;

    public AuthController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping("/register")
    public Owner register(@RequestBody Owner owner) {
        return ownerService.registerOwner(owner);
    }

    // Add login endpoint here
}
