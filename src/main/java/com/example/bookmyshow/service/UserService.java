package com.example.bookmyshow.service;

import com.example.bookmyshow.models.User;
import com.example.bookmyshow.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User signUp(String email, String password) {
        // 1. Check if user already exists
        Optional<User> userOptional = userRepository.findByEmail(email);

        if(userOptional.isPresent()) {
            throw new IllegalArgumentException("User already exists.");
        }

        User user = new User();
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

    public boolean signIn(String email, String password) {
        User user = userRepository.findByEmail(email).get();
        return bCryptPasswordEncoder.matches(password, user.getPassword());

    }
}
