package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.PurchaseDto;

import java.util.List;

//purchases
public interface PurchaseService {
    public Purchase create(PurchaseDto purchaseDto);// POST
    public Purchase update(Long purchaseId, PurchaseDto purchaseDto);//{purchaseId} PUT
    public Purchase findById(Long purchaseId);//{purchaseId} GET
    public List<Purchase> findAll();// GET
    public void deleteById(Long purchaseId);//{purchaseId} DELETE
}
