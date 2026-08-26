package com.pedrohenrique.library_management_api.core.application.usecases.auth;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.UserRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.user.response.AuthResponseDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.user.request.LoginRequestDTO;
import com.pedrohenrique.library_management_api.core.application.exceptions.InvalidCredentialsException;
import com.pedrohenrique.library_management_api.core.domain.entities.User;
import com.pedrohenrique.library_management_api.infra.security.JwtService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCase  {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public LoginUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;

    }

    public AuthResponseDTO execute(LoginRequestDTO dto){
        User user = userRepository.findByEmail(dto.email())
                .orElseThrow(InvalidCredentialsException::new);

        if (!passwordEncoder.matches(dto.password(), user.getPassword())) {
            throw new InvalidCredentialsException();

        }

        if (!user.isActive())  {
            throw new InvalidCredentialsException();

        }

        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(token);
    }
}
