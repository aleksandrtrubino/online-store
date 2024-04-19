package ru.vistar.kionmarket.product;

import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.review.Review;

import java.util.List;
import java.util.Set;

//products
public interface ProductService {
    public ProductResponseDto create(ProductRequestDto productRequestDto);// POST
    public ProductResponseDto update(Long productId, ProductRequestDto productRequestDto);//{productId} PUT
    public void uploadProductImages(Long productId, MultipartFile[] images);//products/{productId}/images POST
    public List<byte[]> getProductImages(Long productId);//products/{productId}/images
    public ProductResponseDto findById(Long productId);//{productId} GET
    public List<ProductResponseDto> findAll();// GET
    public void deleteById(Long productId);//{productId} DELETE

    public Set<Review> getReviews(Long productId);//{productId}/reviews GET
    public Set<Purchase> getPurchases(Long productId);//{productId}/purchases GET
}
