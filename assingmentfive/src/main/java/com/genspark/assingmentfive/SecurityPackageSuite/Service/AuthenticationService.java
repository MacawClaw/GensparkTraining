package com.genspark.assingmentfive.SecurityPackageSuite.Service;

import com.genspark.assingmentfive.SecurityPackageSuite.Controller.AuthenticationRequest;
import com.genspark.assingmentfive.SecurityPackageSuite.Controller.AuthenticationResponse;
import com.genspark.assingmentfive.SecurityPackageSuite.Controller.RegisterRequest;
import com.genspark.assingmentfive.SecurityPackageSuite.Dao.UserDao;
import com.genspark.assingmentfive.SecurityPackageSuite.Entity.User;
import com.genspark.assingmentfive.SecurityPackageSuite.SecurityConfig.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserDao repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(RegisterRequest request) {
        //Ensure the User class under Entity is used here
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();

        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(
                      request.getEmail(),
                      request.getPassword()
              )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }
}
