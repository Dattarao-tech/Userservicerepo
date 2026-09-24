package com.example.demo.Service;

import java.util.List;

import com.example.demo.Entity.User;
import com.example.demo.ServiceImpl.UserAlreadyExistsException;

public interface UserService {
	User registerUser(User user) throws UserAlreadyExistsException;
    List<User> getAllUsers();
    User getUserById(Long id);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
    User findByUsername(String username);
    boolean validateCredentials(User user);

}
