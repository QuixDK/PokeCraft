package ru.pokecraft.site.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.site.models.users.UsersData;

public interface UsersDataRepository extends JpaRepository<UsersData, Long> {
    UsersData findUserDataByUserId(Long id);
}
