package com.rcamis.smis.service;

import com.rcamis.smis.dto.UserInformDto;
import com.rcamis.smis.dto.UserLoginDto;
import com.rcamis.smis.model.User;
import com.rcamis.smis.util.ApiResponse;
import com.rcamis.smis.util.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthService (UserService userService, AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public User registerUser (UserInformDto userInformDto ) {
        return this.userService.createUser(userInformDto);
    }

    public ResponseEntity<ApiResponse<String>> loginUser (UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userLoginDto.getEmail(), userLoginDto.getPassword())
            );

            User user = this.userService.getUserByEmail(userLoginDto.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "User logged in successfully!! 🎉🎉🎉", this.jwtUtil.generateToken(user.getEmail())));
        }
        catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse<>(false, "Provided bad credentials!! 👎👎🏾👎🏼", "Bad Credentials"));
        }
    }
}
