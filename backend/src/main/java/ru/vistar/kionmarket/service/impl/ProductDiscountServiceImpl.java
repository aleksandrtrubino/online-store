package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.repository.ProductDiscountRepository;
import ru.vistar.kionmarket.repository.ProductRepository;
import ru.vistar.kionmarket.service.ProductDiscountService;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.ProductDiscount;
import ru.vistar.kionmarket.dto.ProductDiscountDto;

import java.util.List;
@Service
public class ProductDiscountServiceImpl implements ProductDiscountService {
    private final ProductDiscountRepository productDiscountRepository;
    private final ProductRepository productRepository;

    public ProductDiscountServiceImpl(ProductDiscountRepository productDiscountRepository, ProductRepository productRepository) {
        this.productDiscountRepository = productDiscountRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductDiscount create(ProductDiscountDto productDiscountDto) {
        Product product = productRepository.findById(productDiscountDto.getProductId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found", productDiscountDto.getProductId())));
        ProductDiscount productDiscount = new ProductDiscount();
        productDiscount.setProduct(product);
        productDiscount.setValue(productDiscountDto.getValue());
        productDiscount.setStartDate(productDiscountDto.getStartDate());
        productDiscount.setEndDate(productDiscountDto.getEndDate());
        return productDiscountRepository.save(productDiscount);
    }

    @Override
    public ProductDiscount update(Long productDiscountId, ProductDiscountDto productDiscountDto) {
        ProductDiscount productDiscount = productDiscountRepository.findById(productDiscountId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("ProductDiscount with id %1$s not found", productDiscountId)));
        Product product = productRepository.findById(productDiscountDto.getProductId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found", productDiscountDto.getProductId())));
        productDiscount.setProduct(product);
        productDiscount.setValue(productDiscountDto.getValue());
        productDiscount.setStartDate(productDiscountDto.getStartDate());
        productDiscount.setEndDate(productDiscountDto.getEndDate());
        return productDiscountRepository.save(productDiscount);
    }

    @Override
    public ProductDiscount findById(Long id) {
        ProductDiscount productDiscount = productDiscountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("ProductDiscount with id %1$s not found", id)));
        return productDiscount;
    }

    @Override
    public List<ProductDiscount> findAll() {
        return productDiscountRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productDiscountRepository.deleteById(id);
    }
}
