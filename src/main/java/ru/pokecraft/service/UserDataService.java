package ru.pokecraft.service;

import ru.pokecraft.models.client.user.UserData;
import ru.pokecraft.models.client.user.Users;

public interface UserDataService {
    UserData findUserById(Long userId);

    void checkUser(UserData user);

}