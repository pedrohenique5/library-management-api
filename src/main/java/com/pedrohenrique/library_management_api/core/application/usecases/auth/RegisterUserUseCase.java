package com.pedrohenrique.library_management_api.core.application.usecases.auth;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.UserRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.user.request.RegisterRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.User;
import com.pedrohenrique.library_management_api.core.domain.enums.Role;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class RegisterUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterUserUseCase(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User execute(RegisterRequestDTO dto) {
        if (userRepository.existsByCpf(dto.cpf())) {
            throw new IllegalStateException("Não foi possível completar o cadastro");
        }
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalStateException("Não foi possível completar o cadastro");
        }
        String encodedPassword = passwordEncoder.encode(dto.password());

        User user = new User(
                dto.name(), dto.cpf(), dto.phone(), encodedPassword, dto.email(),
                dto.birthDate(), dto.addressId(), Role.CUSTOMER, dto.profileId(), dto.customLoanLimit());

        return userRepository.save(user);

    }
}
