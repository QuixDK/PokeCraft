package ru.pokecraft.site.service;

import ru.pokecraft.site.models.users.UsersData;

public interface UserDataService {
    UsersData findUserById(Long userId);

    void checkUser(UsersData user);

}