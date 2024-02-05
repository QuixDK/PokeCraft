package ru.pokecraft.site.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.site.models.users.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String username);
    Users findUserById(Long id);
}
