package com.Ecommerce.service;

import com.Ecommerce.DTO.RegisterDTO;
import com.Ecommerce.model.User;
import com.Ecommerce.repository.RoleRepository;
import com.Ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@Transactional
public class UserService {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    @Autowired
    public UserService(RoleRepository roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
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