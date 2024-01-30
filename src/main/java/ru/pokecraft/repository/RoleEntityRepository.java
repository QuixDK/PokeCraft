package ru.pokecraft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.models.client.user.Role;

public interface RoleEntityRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
