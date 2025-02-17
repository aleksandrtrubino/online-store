package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.PurchaseStatus;
import ru.vistar.kionmarket.dto.PurchaseStatusDto;
import ru.vistar.kionmarket.domain.Purchase;

import java.util.List;
import java.util.Set;

//purchase-statuses
public interface PurchaseStatusService {
    public PurchaseStatus create(PurchaseStatusDto purchaseStatusDto);// POST
    public PurchaseStatus update(Long purchaseStatusId, PurchaseStatusDto purchaseStatusDto);//{purchaseStatusId} PUT
    public PurchaseStatus findById(Long purchaseStatusId);//{purchaseStatusId} GET
    public List<PurchaseStatus> findAll();// GET
    public void deleteById(Long purchaseStatusId);//{purchaseStatusId} DELETE

    public Set<Purchase> getPurchases(Long purchaseStatusId);//{purchaseStatusId}/purchases GET
}
