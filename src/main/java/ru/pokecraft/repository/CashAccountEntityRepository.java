package ru.pokecraft.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.pokecraft.models.client.user.CashAccount;

public interface CashAccountEntityRepository extends JpaRepository<CashAccount, Long> {
    CashAccount findByUserId(Long userId);
}
