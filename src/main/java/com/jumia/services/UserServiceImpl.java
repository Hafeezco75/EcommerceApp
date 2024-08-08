package com.jumia.services;

import com.jumia.data.models.Users;
import com.jumia.data.repositories.UserRepository;
import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.requests.RegisterUserRequest;
import com.jumia.dtos.responses.LoginUserResponse;
import com.jumia.dtos.responses.LogoutUserResponse;
import com.jumia.dtos.responses.RegisterUserResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private boolean setLoggedIn;

public UserServiceImpl(UserRepository userRepository) {
   this.userRepository = userRepository;
}

    @Override
    public RegisterUserResponse register(RegisterUserRequest registerUserRequest) {
        validate(registerUserRequest);
        Users user = new Users();
        user.setName(registerUserRequest.getFirstName());
        user.setEmail(registerUserRequest.getLastName());
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        user.setPhoneNumber(registerUserRequest.getPhoneNumber());
        userRepository.save(user);

        RegisterUserResponse registerUserResponse = new RegisterUserResponse();
        registerUserResponse.setMessage("User registered successfully");
        return registerUserResponse;
    }

    @Override
    public LoginUserResponse login(LoginUserRequest loginUserRequest) {
        for (Users user : userRepository.findAll()) {
            if (user.getEmail().equals(loginUserRequest.getEmail())){
                if (user.getPassword().equals(loginUserRequest.getPassword())) {
                    setLoggedIn = true;
                    userRepository.save(user);
                }else {
                    throw new IllegalArgumentException("User Email or Password is incorrect");
                }
            }
        }
        LoginUserResponse loginUserResponse = new LoginUserResponse();
        loginUserResponse.setMessage("You have been logged in successfully");
        return loginUserResponse;
    }

    @Override
    public LogoutUserResponse logout(LoginUserRequest loginUserRequest) {
        for (Users user : userRepository.findAll()) {
            if (user.getEmail().equals(loginUserRequest.getEmail())) {
                if (user.getPassword().equals(loginUserRequest.getPassword())) {
                    setLoggedIn = true;
                    userRepository.save(user);
                }else {
                    throw new IllegalArgumentException("You are not logged in");
                }
            }
        }
        LogoutUserResponse logoutUserResponse = new LogoutUserResponse();
        logoutUserResponse.setMessage("You have been logged out successfully");
        return logoutUserResponse;
    }

    @Override
    public Users findUserByEmail(String email) {
        for (Users user : userRepository.findAll()) {
            if (user.getEmail().equals(email)) {
                return userRepository.findByEmail(email);
            }
        }
        return null;
    }

    @Override
    public Users findUserByPhoneNumber(String phoneNumber) {
        for (Users user: userRepository.findAll())
            if (user.getPhoneNumber().equals(phoneNumber))
                return userRepository.findByPhoneNumber(phoneNumber);
        return null;
    }

//    @Override
//    public Users findUserById(String id) {
//        for (Users user: userRepository.findAll()){
//            if(user.getId().equals(id)){
//                return userRepository.findById(id).get();
//            }
//        }
//        return null;
//    }

    @Override
    public void deleteUser(String id) {
        for (Users user : userRepository.findAll()) {
            if(user.getId().equals(id)){
                userRepository.delete(user);
            }
        }
    }

    private void validate(RegisterUserRequest registerUserRequest) {
        String email = registerUserRequest.getEmail();

        for (Users users : userRepository.findAll()) {
            if (users.getEmail().equals(email)) {throw new IllegalArgumentException("Email already exists,select another email");}
        }
    }




}
