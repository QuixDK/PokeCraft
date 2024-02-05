package ru.pokecraft.site.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.site.models.users.Role;

public interface RoleEntityRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
