package ru.pokecraft.service;

import ru.pokecraft.models.client.user.Users;

public interface UserService {
    Users findUserByUsernameWithCheck(String username);
    Users findUserByUsername(String username);
    Users findUserByUsernameAndPassword(String username, String password);
    Users saveUser(Users users);
    Users findUserById(Long id);
    void checkUser(Users user);
}
