package com.rcamis.smis.security;

import com.rcamis.smis.exception.NotFoundException;
import com.rcamis.smis.model.User;
import com.rcamis.smis.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public CustomUserDetailsService ( UserRepository userRepository ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.userRepository.getUserByEmail(username).orElseThrow(() -> new NotFoundException("User Not Found!!"));
        return new CustomUserDetails(user);
    }
}
