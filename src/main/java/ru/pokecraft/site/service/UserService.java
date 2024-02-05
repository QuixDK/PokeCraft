package ru.pokecraft.site.service;

import ru.pokecraft.site.models.login.RegistrationRequest;
import ru.pokecraft.site.models.users.Users;

import javax.security.sasl.AuthenticationException;

public interface UserService {
    Users findUserByUsername(String username);
    Users findUserByUsernameAndPassword(String username, String password) throws AuthenticationException;
    Users findUserById(Long id);
    Users createUsers(RegistrationRequest request);
    void checkUser(Users user);
}
