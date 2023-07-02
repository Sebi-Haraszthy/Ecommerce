package com.Ecommerce.service;

import com.Ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

//    public User register(RegisterDTO newUser) {
//        Optional<User> foundUser = userRepository.findUserByUsername(newUser.getUsername());
//
//        if(foundUser.isPresent()) {
//            throw new ResponseStatusException(HttpStatus.CREATED, "User already exists!");
//        }
//
//        User user = new User();
//        user.setName(newUser.getUsername());
//
//    }
}