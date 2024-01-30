package ru.pokecraft.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pokecraft.exceptions.UserDataNotFoundException;
import ru.pokecraft.exceptions.UserNotFoundException;
import ru.pokecraft.models.client.user.UserData;
import ru.pokecraft.models.client.user.Users;
import ru.pokecraft.repository.UserDataEntityRepository;
import ru.pokecraft.repository.UserEntityRepository;

@Service
@AllArgsConstructor
public class UserDataServiceImpl implements UserDataService{

    private final UserDataEntityRepository userRepository;
    @Override
    public UserData findUserById(Long id) {
        UserData userById = userRepository.findUserDataByUserId(id);
        checkUser(userById);
        return userById;
    }
    @Override
    public void checkUser(UserData user) {
        if (user == null) {
            throw new UserDataNotFoundException("UserData not found");
        }
    }
}
