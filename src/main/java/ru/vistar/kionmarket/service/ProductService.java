package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.dto.ProductDto;

import java.util.List;
import java.util.Set;

public interface ProductService {
    public Product create(ProductDto productDto);//products
    public Product update(Long id, ProductDto productDto);//products/{id}
    public Product findById(Long id);//products/{id}
    public List<Product> findAll();//products
    public void deleteById(Long id);//products/{id}

    public Set<Review> getReviews(Long id);//products/{productId}/reviews
    public Set<Purchase> getPurchases(Long id);//products/{productId}/purchases
}
