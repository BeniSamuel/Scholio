package com.rcamis.smis.repository;

import com.rcamis.smis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> getUserByEmail (String email);
    Optional<User> getUserById (int id);
}
