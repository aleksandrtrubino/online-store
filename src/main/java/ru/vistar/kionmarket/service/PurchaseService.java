package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.ProductDto;
import ru.vistar.kionmarket.dto.PurchaseDto;

import java.util.List;

public interface PurchaseService {
    public Purchase create(PurchaseDto purchaseDto);//purchases
    public Purchase update(PurchaseDto purchaseDto);//purchases
    public Purchase findById(Long purchaseId);//purchases/{purchaseId}
    public List<Purchase> findAll();//purchases
    public void deleteById(Long purchaseId);//purchases/{purchaseId}
}
