package ru.vistar.kionmarket.purchase;

import java.util.List;

//purchases
public interface PurchaseService {
    public Purchase create(PurchaseDto purchaseDto);// POST
    public Purchase update(Long purchaseId, PurchaseDto purchaseDto);//{purchaseId} PUT
    public Purchase findById(Long purchaseId);//{purchaseId} GET
    public List<Purchase> findAll();// GET
    public void deleteById(Long purchaseId);//{purchaseId} DELETE
}
