package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.PurchaseStatus;
import ru.vistar.kionmarket.dto.PurchaseStatusDto;

import java.util.List;
import java.util.Set;

public interface PurchaseStatusService {
    public PurchaseStatus create(PurchaseStatusDto purchaseStatusDto);//purchase-statuses
    public PurchaseStatus update(Long purchaseStatusId, PurchaseStatusDto purchaseStatusDto);//purchase-statuses
    public PurchaseStatus findById(Long purchaseStatusId);//purchase-statuses/{purchaseStatusId}
    public List<PurchaseStatus> findAll();//purchase-statuses
    public void deleteById(Long purchaseStatusId);//purchase-statuses/{purchaseStatusId}

    public Set<Purchase> getPurchases(Long purchaseStatusId);//purchase-statuses/{purchaseStatusId}/purchases
}
