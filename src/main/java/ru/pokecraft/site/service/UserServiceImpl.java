package ru.pokecraft.site.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pokecraft.site.exceptions.UserNotFoundException;
import ru.pokecraft.site.models.login.RegistrationRequest;
import ru.pokecraft.site.models.users.Users;
import ru.pokecraft.site.models.users.UsersData;
import ru.pokecraft.site.repository.UsersRepository;

import javax.security.sasl.AuthenticationException;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository userRepository;

    @Override
    public Users findUserById(Long id) {
        Users userById = userRepository.findUserById(id);
        checkUser(userById);
        return userById;
    }

    @Override
    public Users createUsers(RegistrationRequest request) {
        Users user = new Users();
        UsersData userData = new UsersData();
        userData.setEmail(request.getEmail());
        user.setUsersData(userData);
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        userRepository.save(user);
        return user;
    }

    @Override
    public void checkUser(Users user) {
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public Users findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow();
    }

    @Override
    public Users findUserByUsernameAndPassword(String username, String password) throws AuthenticationException {
        Users user = findUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        throw new AuthenticationException("Wrong params");
    }


}
