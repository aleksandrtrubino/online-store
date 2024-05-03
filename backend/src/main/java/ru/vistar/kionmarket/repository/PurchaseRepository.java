package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
