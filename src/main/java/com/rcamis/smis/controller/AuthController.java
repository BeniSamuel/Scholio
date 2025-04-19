package com.rcamis.smis.controller;

import com.rcamis.smis.dto.UserInformDto;
import com.rcamis.smis.dto.UserLoginDto;
import com.rcamis.smis.model.User;
import com.rcamis.smis.service.AuthService;
import com.rcamis.smis.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rcamis/v1/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController ( AuthService authService ) {
        this.authService = authService;
    }

    @PostMapping("/register-user")
    public ResponseEntity<ApiResponse<User>> registerUser (@RequestBody UserInformDto userInformDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse<>(true, "Successfully created user!! 🎉🎉🎉", this.authService.registerUser(userInformDto)));
    }

    @PostMapping("/login-user")
    public ResponseEntity<ApiResponse<String>> loginUser (@RequestBody UserLoginDto userLoginDto) {
        return this.authService.loginUser(userLoginDto);
    }
}
