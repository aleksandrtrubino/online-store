package ru.vistar.kionmarket.product;

import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.review.Review;

import java.util.List;
import java.util.Set;

//products
public interface ProductService {
    public Product create(ProductDto productDto);// POST
    public Product update(Long productId, ProductDto productDto);//{productId} PUT
    public Product findById(Long productId);//{productId} GET
    public List<Product> findAll();// GET
    public void deleteById(Long productId);//{productId} DELETE

    public Set<Review> getReviews(Long productId);//{productId}/reviews GET
    public Set<Purchase> getPurchases(Long productId);//{productId}/purchases GET
}
