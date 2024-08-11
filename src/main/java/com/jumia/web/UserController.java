package com.jumia.web;

import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.requests.RegisterUserRequest;
import com.jumia.dtos.responses.ApiResponse;
import com.jumia.dtos.responses.LoginUserResponse;
import com.jumia.dtos.responses.LogoutUserResponse;
import com.jumia.dtos.responses.RegisterUserResponse;
import com.jumia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserRequest registerUserRequest) {
        try{
            RegisterUserResponse registerUserResponse = userService.register(registerUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, registerUserResponse), HttpStatus.CREATED);
        } catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, loginUserResponse), HttpStatus.CREATED);
        }catch (Exception exception){
            return new ResponseEntity<>(new ApiResponse(false, exception.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LoginUserRequest loginUserRequest) {
        try {
            LogoutUserResponse logoutUserResponse = userService.logout(loginUserRequest);
            return new ResponseEntity<>(new ApiResponse(true, logoutUserResponse), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false, e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }




}
