package ru.vistar.kionmarket.service;



import ru.vistar.kionmarket.domain.ProductDiscount;
import ru.vistar.kionmarket.dto.ProductDiscountDto;

import java.util.List;

public interface ProductDiscountService {
    public ProductDiscount create(ProductDiscountDto productDiscountDto);
    public ProductDiscount update(Long productDiscountId, ProductDiscountDto productDiscountDto);
    public ProductDiscount findById(Long productDiscountId);
    public List<ProductDiscount> findAll();
    public void deleteById(Long id);
}
