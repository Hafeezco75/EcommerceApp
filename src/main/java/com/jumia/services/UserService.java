package com.jumia.services;

import com.jumia.data.models.Users;
import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.requests.RegisterUserRequest;
import com.jumia.dtos.responses.LoginUserResponse;
import com.jumia.dtos.responses.LogoutUserResponse;
import com.jumia.dtos.responses.RegisterUserResponse;


public interface UserService {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
    LoginUserResponse login(LoginUserRequest loginUserRequest);
    LogoutUserResponse logout(LoginUserRequest loginUserRequest);

    Users findUserByEmail(String email);
    Users findUserByPhoneNumber(String phoneNumber);
//    Users findUserById(String id);
    void deleteUser(String id);

}


