package com.pedrohenrique.library_management_api.core.application.usecases;

import com.pedrohenrique.library_management_api.core.application.contracts.repositories.UserRepository;
import com.pedrohenrique.library_management_api.core.application.dtos.RegisterRequestDTO;
import com.pedrohenrique.library_management_api.core.domain.entities.User;
import lombok.NoArgsConstructor;
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
            throw new IllegalStateException("usuario já cadastrado com esse cpf");
        }
        if (userRepository.existsByEmail(dto.email())) {
            throw new IllegalStateException("usuario já cadastrado com esse email");
        }
        String encodedPassword = passwordEncoder.encode(dto.password());

        User user = new User(
                dto.name(), dto.cpf(), dto.phone(), encodedPassword, dto.email(),
                dto.birthDate(), dto.addressId(), dto.role(), dto.profileId(), dto.customLoanLimit());

        return userRepository.save(user);

    }
}
