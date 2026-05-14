package com.ritesh.insightdocs.security;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ritesh.insightdocs.security.dto.AuthResponse;
import com.ritesh.insightdocs.security.dto.LoginRequest;
import com.ritesh.insightdocs.security.dto.SignupRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public AuthResponse signup(@Valid @RequestBody SignupRequest request) {
        return authService.SignUp(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.LogIn(request);
    }

    @GetMapping("/me")
    public Map<String, String> me(Authentication authentication) {
        return Map.of("email", authentication.getName());
    }
}
