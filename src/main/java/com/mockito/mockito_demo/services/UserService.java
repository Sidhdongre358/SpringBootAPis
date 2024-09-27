package com.mockito.mockito_demo.services;

import com.mockito.mockito_demo.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<Long, User> userMap = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    public User getUser(Long id) {
        return userMap.get(id);
    }

    public User createUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    public void deleteUser(Long id) {
        userMap.remove(id);
    }
}
