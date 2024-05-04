package ru.vistar.kionmarket.service;

import jakarta.annotation.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.ProductRequestDto;
import ru.vistar.kionmarket.dto.ProductResponseDto;

import java.util.List;
import java.util.Set;

//products
public interface ProductService {
    public ProductResponseDto create(ProductRequestDto productRequestDto);// POST
    public ProductResponseDto update(Long productId, ProductRequestDto productRequestDto);//{productId} PUT
    public void uploadProductImages(Long productId, MultipartFile[] images);//products/{productId}/images POST
    public List<byte[]> getProductImages(Long productId);//products/{productId}/images
    public ProductResponseDto findById(Long productId);//{productId} GET
    public Page<ProductResponseDto> findAll(
            Integer page,
            Integer limit,
            String sort,
            String order,
            @Nullable Long categoryFilter,
            @Nullable Long subcategoryFilter,
            @Nullable Integer priceFrom,
            @Nullable Integer priceTo,
            @Nullable Long shopFilter,
            @Nullable String search,
            @Nullable Boolean isFavorite);// GET
    public void deleteById(Long productId);//{productId} DELETE

    public Set<Review> getReviews(Long productId);//{productId}/reviews GET
    public Set<Purchase> getPurchases(Long productId);//{productId}/purchases GET
}
