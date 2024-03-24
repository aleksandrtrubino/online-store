package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.UserBuyer;

public interface UserBuyerRepository extends JpaRepository<UserBuyer, Long> {
}
