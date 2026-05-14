package com.ritesh.insightdocs.security;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ritesh.insightdocs.exception.InvalidCredentialsException;
import com.ritesh.insightdocs.exception.UserAlreadyExistsException;
import com.ritesh.insightdocs.security.dto.AuthResponse;
import com.ritesh.insightdocs.security.dto.LoginRequest;
import com.ritesh.insightdocs.security.dto.SignupRequest;
import com.ritesh.insightdocs.user.User;
import com.ritesh.insightdocs.user.UserRepository;

@Service
public class AuthService {
    private final JwtUtil jwtUtil;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtil) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    public AuthResponse SignUp(SignupRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new UserAlreadyExistsException("Email already exists.");
        }
        if(userRepository.existsByNumber(request.getNumber())){
            throw new UserAlreadyExistsException("Number already exists.");
        }
        if(userRepository.existsByNickName(request.getNickName())){
            throw new UserAlreadyExistsException("Nickname already exists.");
        }

        if (userRepository.existsByNickName(request.getNickName())) {
        throw new UserAlreadyExistsException("Nickname already taken");
    }
    User user = User.builder()
    .email(request.getEmail())
    .password(passwordEncoder.encode(request.getPassword()))
    .fullName(request.getFullName())
    .nickName(request.getNickName())
    .countryCode(request.getCountryCode())
    .number(request.getNumber())
    .build();

    userRepository.save(user);

    AuthResponse response =AuthResponse.builder().email(request.getEmail()).token(jwtUtil.buildToken(request.getEmail())).msg("Done").build();
    return response;

    }

    public AuthResponse LogIn(LoginRequest request){
        if(!userRepository.existsByEmail(request.getEmail())){
            throw new InvalidCredentialsException("email doesnt exist");
        }
        
        if(passwordEncoder.matches(request.getPassword(), userRepository.findByEmail(request.getEmail()).getPassword())){
            return AuthResponse.builder().email(request.getEmail()).token(jwtUtil.buildToken(request.getEmail())).msg("Welcome").build();
        }
        else{
            throw new InvalidCredentialsException("wrong password");
        }
    }

    
}