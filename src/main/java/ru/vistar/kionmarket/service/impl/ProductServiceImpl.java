package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.ProductDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.repository.ProductRepository;
import ru.vistar.kionmarket.repository.ShopRepository;
import ru.vistar.kionmarket.repository.SubcategoryRepository;
import ru.vistar.kionmarket.service.ProductService;

import java.util.List;
import java.util.Set;
@Service
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    final ShopRepository shopRepository;
    final SubcategoryRepository subcategoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository, SubcategoryRepository subcategoryRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Product create(ProductDto productDto) {
        Product product = new Product();
        Subcategory subcategory = subcategoryRepository.findById(productDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productDto.getShopId())));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(product.getPrice());
        product.setPrevPrice(productDto.getPrevPrice());
        product.setSubcategory(subcategory);
        product.setShop(shop);
        return productRepository.save(product);
    }

    @Override
    public Product update(Long id, ProductDto productDto) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", id)));
        Subcategory subcategory = subcategoryRepository.findById(productDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productDto.getShopId())));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(product.getPrice());
        product.setPrevPrice(productDto.getPrevPrice());
        product.setSubcategory(subcategory);
        product.setShop(shop);
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", id)));
        return product;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Set<Review> getReviews(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", id)));
        return product.getReviews();
    }

    @Override
    public Set<Purchase> getPurchases(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", id)));
        return product.getPurchases();
    }
}
