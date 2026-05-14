# Future Auth Structure

Possible structure when adding multiple login methods like email/password and Google login:

```text
src/main/java/com/ritesh/insightdocs/security/
├── controller/
│   └── AuthController.java
├── service/
│   ├── AuthService.java
│   └── DefaultAuthService.java
├── provider/
│   ├── AuthProvider.java
│   ├── EmailPasswordAuthProvider.java
│   └── GoogleAuthProvider.java
├── token/
│   ├── TokenService.java
│   └── JwtTokenService.java
├── dto/
│   ├── AuthResponse.java
│   ├── LoginRequest.java
│   ├── SignupRequest.java
│   └── GoogleLoginRequest.java
├── filter/
│   └── JwtAuthFilter.java
└── config/
    └── SecurityConfig.java
```
