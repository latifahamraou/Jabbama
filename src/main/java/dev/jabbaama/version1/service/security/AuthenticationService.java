package dev.jabbaama.version1.service.security;


import dev.jabbaama.version1.model.dto.request.SignInRequest;
import dev.jabbaama.version1.model.dto.request.SignUpRequest;
import dev.jabbaama.version1.model.dto.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signin(SignInRequest request);
    Boolean hasNoUserWithEmail(String email);
}