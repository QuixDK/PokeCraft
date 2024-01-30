package ru.pokecraft.service;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pokecraft.exceptions.UserNotFoundException;
import ru.pokecraft.models.client.user.Role;
import ru.pokecraft.models.client.user.Users;
import ru.pokecraft.repository.CashAccountEntityRepository;
import ru.pokecraft.repository.RoleEntityRepository;
import ru.pokecraft.repository.UserEntityRepository;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserEntityRepository userRepository;
    private final RoleEntityRepository roleRepository;
    private final CashAccountEntityRepository cashRepository;

    @Override
    public Users saveUser(Users users) {
        Role userRole = roleRepository.findByName("ROLE_USER");
        users.setRole(userRole);
        users.setPassword(users.getPassword());
        users.setEmail(users.getEmail());
        Users toReturn = userRepository.save(users);
        return toReturn;
    }

    @Override
    public Users findUserById(Long id) {
        Users userById = userRepository.findUserById(id);
        checkUser(userById);
        return userById;
    }

    @Override
    public void checkUser(Users user) {
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public Users findUserByUsernameWithCheck(String username) {
        Users userByUsername = userRepository.findUserByUsername(username);
        checkUser(userByUsername);
        return userByUsername;
    }

    @Override
    public Users findUserByUsername(String username) {
        return userRepository.findUserByUsername(username);
    }

    @Override
    public Users findUserByUsernameAndPassword(String username, String password) {
        Users user = findUserByUsername(username);
        if (user != null) {
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }


}
