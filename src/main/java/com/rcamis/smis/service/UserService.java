package com.rcamis.smis.service;

import com.rcamis.smis.dto.UserInformDto;
import com.rcamis.smis.enums.Role;
import com.rcamis.smis.exception.NotFoundException;
import com.rcamis.smis.model.User;
import com.rcamis.smis.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService (UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers () {
        return this.userRepository.findAll();
    }

    public User getUserById (int id) {
        return this.userRepository.getUserById(id).orElseThrow(() -> new NotFoundException("User Not Found!!"));
    }

    public User getUserByEmail (String email) {
        return this.userRepository.getUserByEmail(email).orElseThrow(() -> new NotFoundException("User Not Found!!"));
    }

    public User createUser (UserInformDto userInformDto) {
        User newUser = new User(userInformDto.getName(), userInformDto.getEmail(), passwordEncoder.encode(userInformDto.getPassword()), Role.TEACHER);
        return this.userRepository.save(newUser);
    }

    public User updateUser (int id, UserInformDto userInformDto) {
       User user = this.getUserById(id);
       user.setName(userInformDto.getName());
       user.setEmail(userInformDto.getEmail());
       user.setPassword(user.getPassword());
       return this.userRepository.save(user);
    }

    public String deleteUser ( int id ) {
        this.userRepository.deleteById(id);
        return "User Deleted";
    }
}
