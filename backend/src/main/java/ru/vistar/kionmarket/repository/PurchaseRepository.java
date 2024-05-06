package ru.vistar.kionmarket.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.vistar.kionmarket.domain.Purchase;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long>, JpaSpecificationExecutor<Purchase> {
    public List<Purchase> findAllByUserIdAndPurchaseStatusIdAndProductId(Long userId, Long purchaseStatusId, Long productId);
    public List<Purchase> findAllByUserIdAndPurchaseStatusId(Long userId, Long purchaseStatusId, Sort sort);

    public void deletePurchaseByUserIdAndProductId(Long userId, Long productId);
}
