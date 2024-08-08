package com.jumia.web;

import com.jumia.data.models.Users;
import com.jumia.data.repositories.UserRepository;
import com.jumia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    private UserService userService;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Users> findUserByPhoneNumber(@PathVariable String phoneNumber) {
        Users userServices = userRepository.findByPhoneNumber(phoneNumber);
        try {
            return new ResponseEntity<>(userServices, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/{email}/{password}")
    public ResponseEntity<?> loginUser(@PathVariable String email, String password) {
        try {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
