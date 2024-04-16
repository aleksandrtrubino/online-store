package ru.vistar.kionmarket.productdiscount;



import java.util.List;

public interface ProductDiscountService {
    public ProductDiscount create(ProductDiscountDto productDiscountDto);
    public ProductDiscount update(Long id, ProductDiscountDto productDiscountDto);
    public ProductDiscount findById(Long id);
    public List<ProductDiscount> findAll();
    public void deleteById(Long id);
}
