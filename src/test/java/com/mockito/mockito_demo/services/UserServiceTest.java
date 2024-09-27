package com.mockito.mockito_demo.services;

import com.mockito.mockito_demo.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserService();
        userService.createUser(new User(1L, "John Doe", "johndoe@gmail.com"));

    }

    @Test
    void getAllUserTest() {
        List<User> userList = userService.getAllUsers();
        // Assertions.assertNotNull(userList);
        Assertions.assertEquals(1, userList.size());
    }

    @Test
    void getUserByIdTest() {

        User user = userService.getUser(1L);
        Assertions.assertNotNull(user);
        Assertions.assertEquals("John Doe", user.getName());

    }

    @Test
    void createUserTest() {
        User user = new User(2L, "Jane Doe", "janedoe@gmail.com");
        userService.createUser(user);
        Assertions.assertEquals(2, userService.getAllUsers().size());
    }

    @Test
    void deleteUserByIdTest() {
        userService.deleteUser(1L);
        Assertions.assertNull(userService.getUser(1L));
    }

}
