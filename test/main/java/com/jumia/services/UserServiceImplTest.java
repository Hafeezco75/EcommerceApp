package com.jumia.services;
import com.jumia.dtos.requests.LoginUserRequest;
import com.jumia.dtos.requests.RegisterUserRequest;
import com.jumia.dtos.responses.LoginUserResponse;
import com.jumia.dtos.responses.LogoutUserResponse;
import com.jumia.dtos.responses.RegisterUserResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;

    @Test
    public void testThatUserCanBeRegistered() {
        RegisterUserRequest registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setFirstName("Moe");
        registerUserRequest.setLastName("Blue");
        registerUserRequest.setEmail("balovillip@gmail.com");
        registerUserRequest.setPassword("12347890");
        registerUserRequest.setPhoneNumber("2334567870");
        RegisterUserResponse registerUserResponse = userService.register(registerUserRequest);
        assertThat(registerUserResponse).isNotNull();
        assertThat(registerUserResponse.getMessage()).isEqualTo("User registered successfully");
    }

    @Test
    public void testThatUserCanBeLoggedIn() {
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("balotelli@gmail.com");
        loginUserRequest.setPassword("12347890");
        LoginUserResponse loginUserResponse = userService.login(loginUserRequest);
        assertThat(loginUserResponse).isNotNull();
        assertThat(loginUserResponse.getMessage()).isEqualTo("You have been logged in successfully");
    }

    @Test
    public void testThatUserCanBeLoggedOut() {
        LoginUserRequest loginUserRequest = new LoginUserRequest();
        loginUserRequest.setEmail("deji@gmail.com");
        loginUserRequest.setPassword("12345678");
        LogoutUserResponse logoutUserResponse = userService.logout(loginUserRequest);
        assertThat(logoutUserResponse).isNotNull();
        assertThat(logoutUserResponse.getMessage()).isEqualTo("You have been logged out successfully");
    }

    @Test
    public void testThatUserCanBeDeleted() {

    }
}
