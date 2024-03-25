package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.dto.ProductDto;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public Product create(ProductDto cityDto);//products
    public Product update(ProductDto cityDto);//products
    public Product findById(Long id);//products
    public List<Product> findAll();//products
    public void deleteById(Long id);//products

    public Set<Review> getReviews(Long productId);//products/{productId}/reviews
    public Set<Purchase> getPurchases(Long productId);//products/{productId}/purchases
}
