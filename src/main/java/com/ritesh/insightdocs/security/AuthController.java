    package com.ritesh.insightdocs.security;

    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    import com.ritesh.insightdocs.security.dto.AuthResponse;
    import com.ritesh.insightdocs.security.dto.LoginRequest;
    import com.ritesh.insightdocs.security.dto.SignupRequest;

    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;


    @RestController
    @RequestMapping("/api/auth")
    public class AuthController {
        private final AuthService authService;
        AuthController(AuthService authService){
            this.authService = authService;
        }

        @PostMapping("/signup")
        public AuthResponse signup(@RequestBody SignupRequest request) {
            
            return authService.SignUp(request);
        }

        @PostMapping("/login")
        public AuthResponse login(@RequestBody LoginRequest request) {
            
            
            return authService.LogIn(request);
        }
        
    }
