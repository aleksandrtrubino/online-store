package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.PurchaseStatus;

public interface PurchaseStatusRepository extends JpaRepository<PurchaseStatus, Long> {
}
