package com.pedrohenrique.library_management_api.presentation.api.auth;

import com.pedrohenrique.library_management_api.core.application.dtos.AuthResponseDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.LoginRequestDTO;
import com.pedrohenrique.library_management_api.core.application.dtos.RegisterRequestDTO;
import com.pedrohenrique.library_management_api.core.application.usecases.auth.LoginUseCase;
import com.pedrohenrique.library_management_api.core.application.usecases.auth.RegisterUserUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final RegisterUserUseCase registerUserUseCase;
    private final LoginUseCase loginUseCase;

    public AuthController(RegisterUserUseCase registerUserUseCase, LoginUseCase loginUseCase) {
        this.registerUserUseCase = registerUserUseCase;
        this.loginUseCase = loginUseCase;

    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequestDTO dto){
        registerUserUseCase.execute(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginRequestDTO dto){
        AuthResponseDTO response = loginUseCase.execute(dto);
        return ResponseEntity.ok(response);
    }
}
