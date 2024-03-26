package ru.vistar.kionmarket.shop;

import ru.vistar.kionmarket.product.Product;

import java.util.List;
import java.util.Set;

public interface ShopService {
    public Shop create(ShopDto shopDto);//shops
    public Shop update(ShopDto shopDto);//shops
    public Shop findById(Long shopId);//shops/{shopId}
    public List<Shop> findAll();//shops
    public void deleteById(Long shopId);//shops/{shopId}
    public Set<Product> getProducts(Long shopId);//shops/{shopId}/products
}
