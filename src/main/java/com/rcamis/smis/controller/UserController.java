package com.rcamis.smis.controller;

import com.rcamis.smis.dto.UserInformDto;
import com.rcamis.smis.model.User;
import com.rcamis.smis.service.UserService;
import com.rcamis.smis.util.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rcamis/v1/user")
public class UserController {
    private final UserService userService;

    public UserController ( UserService userService ) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<ApiResponse<List<User>>> getUsers () {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained users!!! 🎉🎉🎉", this.userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUser (@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully obtained a user!!! 🎉🎉🎉", this.userService.getUserById(id)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser (@PathVariable int id, @RequestBody UserInformDto userInformDto) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Successfully updated user!!! 🎉🎉🎉", this.userService.updateUser(id, userInformDto)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<String>> deleteUser (@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(new ApiResponse<>(true, "Deleted user successfully!!! 🎉🎉🎉", this.userService.deleteUser(id)));
    }
}
