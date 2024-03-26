package ru.vistar.kionmarket.purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.purchase.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}
