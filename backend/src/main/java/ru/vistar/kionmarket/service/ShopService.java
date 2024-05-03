package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Shop;
import ru.vistar.kionmarket.dto.ShopDto;

import java.util.List;
import java.util.Set;

//shops
public interface ShopService {
    public Shop create(ShopDto shopDto);// POST
    public Shop update(Long shopId, ShopDto shopDto);//{shopId} PUT
    public Shop findById(Long shopId);//{shopId} GET
    public List<Shop> findAll();// GET
    public void deleteById(Long shopId);//{shopId} DELETE

    public Set<Product> getProducts(Long shopId);//{shopId}/products GET
}
