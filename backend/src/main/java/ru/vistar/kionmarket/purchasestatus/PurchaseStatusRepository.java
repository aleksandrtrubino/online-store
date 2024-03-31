package ru.vistar.kionmarket.purchasestatus;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.purchasestatus.PurchaseStatus;

public interface PurchaseStatusRepository extends JpaRepository<PurchaseStatus, Long> {
}
