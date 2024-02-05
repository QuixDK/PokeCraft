package ru.pokecraft.site.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.pokecraft.site.exceptions.UserDataNotFoundException;
import ru.pokecraft.site.models.users.UsersData;
import ru.pokecraft.site.repository.UsersDataRepository;

@Service
@AllArgsConstructor
public class UserDataServiceImpl implements UserDataService{

    private final UsersDataRepository userRepository;
    @Override
    public UsersData findUserById(Long id) {
        UsersData userById = userRepository.findUserDataByUserId(id);
        checkUser(userById);
        return userById;
    }
    @Override
    public void checkUser(UsersData user) {
        if (user == null) {
            throw new UserDataNotFoundException("UserData not found");
        }
    }
}
