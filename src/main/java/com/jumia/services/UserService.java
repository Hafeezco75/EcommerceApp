package com.jumia.services;

import com.jumia.data.models.Users;
import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.requests.RegisterUserRequest;
import com.jumia.dtos.responses.LoginUserResponse;
import com.jumia.dtos.responses.LogoutUserResponse;
import com.jumia.dtos.responses.RegisterUserResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {
    RegisterUserResponse register(RegisterUserRequest registerUserRequest);
    LoginUserResponse login(LoginUserRequest loginUserRequest);
    LogoutUserResponse logout(LoginUserRequest loginUserRequest);
    void deleteUser(String id);

    Users findUserEmail(String email);
    Users findUserByPhoneNumber(String phoneNumber);

    Optional<Users> findUserById(String userId);
//    Users findUserById(String id);


}


