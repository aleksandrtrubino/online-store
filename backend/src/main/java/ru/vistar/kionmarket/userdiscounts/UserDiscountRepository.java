package ru.vistar.kionmarket.userdiscounts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDiscountRepository extends JpaRepository<UserDiscount, Long> {
}
