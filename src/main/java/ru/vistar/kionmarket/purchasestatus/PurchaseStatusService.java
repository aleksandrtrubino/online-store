package ru.vistar.kionmarket.purchasestatus;

import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.purchasestatus.PurchaseStatus;
import ru.vistar.kionmarket.purchasestatus.PurchaseStatusDto;

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
