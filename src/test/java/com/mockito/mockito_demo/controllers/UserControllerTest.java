package com.mockito.mockito_demo.controllers;

import com.mockito.mockito_demo.controller.UserController;
import com.mockito.mockito_demo.model.User;
import com.mockito.mockito_demo.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    public UserControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllUsersTest() {

        when(userService.getAllUsers()).
                thenReturn(Arrays.asList(new User(1L, "John Doe", "johndoe@gmail.com")));
        List<User> userList = userController.getAllUsers();

        Assertions.assertEquals(1, userList.size());
    }

    @Test
    void getUserByIdTest() {
        User user = new User(1L, "John Doe", "johndoe@gmail.com");
        when(userService.getUser(1L)).thenReturn(user);

        ResponseEntity<User> response = userController.getUserById(1L);
        Assertions.assertEquals(200, response.getStatusCodeValue());
        Assertions.assertEquals("John Doe", response.getBody().getName());
    }
}
