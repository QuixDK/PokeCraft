package ru.pokecraft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.models.client.user.UserData;

public interface UserDataEntityRepository extends JpaRepository<UserData, Long> {
    UserData findUserDataByUserId(Long id);
}
