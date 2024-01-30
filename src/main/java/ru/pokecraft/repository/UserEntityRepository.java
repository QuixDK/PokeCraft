package ru.pokecraft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.models.client.user.Users;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Users findUserById(Long id);
}
