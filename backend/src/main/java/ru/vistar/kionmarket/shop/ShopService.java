package ru.vistar.kionmarket.shop;

import ru.vistar.kionmarket.product.Product;

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
