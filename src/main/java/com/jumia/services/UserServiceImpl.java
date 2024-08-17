package com.jumia.services;

import com.jumia.data.models.RoleType;
import com.jumia.data.models.Users;
import com.jumia.data.repositories.UserRepository;
import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.requests.RegisterUserRequest;
import com.jumia.dtos.responses.LoginUserResponse;
import com.jumia.dtos.responses.LogoutUserResponse;
import com.jumia.dtos.responses.RegisterUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    private boolean setLoggedIn;


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
        //validateLogin(loginUserRequest);
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
    public Users findUserByPhoneNumber(String phoneNumber) {
        for (Users user: userRepository.findAll()) {
            if (user.getPhoneNumber().equals(phoneNumber)) {
                return userRepository.findByPhoneNumber(phoneNumber);
            }
        }
        return null;
    }

    @Override
    public Optional<Users> findUserById(String userId) {
        return Optional.empty();
    }

    @Override
    public void deleteUser(String id){
        try{
           Optional<Users> user = userRepository.findById(id);
           if(user.get().getRole() == RoleType.ADMIN){
               userRepository.deleteById(id);
           }
        }catch (Exception e){
           throw new RuntimeException(e.getMessage());
        }
    }

    private void validate(RegisterUserRequest registerUserRequest) {
        String email = registerUserRequest.getEmail();

        for (Users users : userRepository.findAll()) {
            if (users.getEmail().equals(email)) {
                throw new IllegalArgumentException("Email already exists,select another email");
            }
            userRepository.findAll();
        }
    }


    private void validateLogin(LoginUserRequest loginUserRequest) {
        String email = loginUserRequest.getEmail();

        for (Users users : userRepository.findAll()) {
            if (users.getEmail().equals(email)) {
                throw new IllegalArgumentException("Email already in use,select another email");
            }else {
                userRepository.save(users);
            }
        }
    }

    @Override
    public List<Users> getAllUsers(){
        return userRepository.findAll();
    }




}
