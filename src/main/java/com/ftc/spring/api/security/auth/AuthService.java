package com.ftc.spring.api.security.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ftc.spring.api.entitys.Usuario;
import com.ftc.spring.api.repository.UsuarioRepositorio;
import com.ftc.spring.api.security.jwt.JwtService;
import com.ftc.spring.api.security.role.Role;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));
        UserDetails user = usuarioRepositorio.findByNombre(request.getUserName()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
            .token(token)
            .result(true)
            .build();
    }

    public AuthResponse register(RegisterRequest request) {
        Usuario user = Usuario.builder()
            .nombre(request.getUserName())
            .correo(request.getCorreo())
            .password(passwordEncoder.encode( request.getPassword()))
            .role(Role.USER)
            .build();
        usuarioRepositorio.save(user);

        return AuthResponse.builder()
        .token(jwtService.getToken(user))
        .result(true)
        .build();
    }

}