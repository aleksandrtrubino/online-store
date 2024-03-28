package ru.vistar.kionmarket.product;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.shop.ShopRepository;
import ru.vistar.kionmarket.subcategory.SubcategoryRepository;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.shop.Shop;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.List;
import java.util.Set;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final SubcategoryRepository subcategoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository, SubcategoryRepository subcategoryRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Product create(ProductDto productDto) {

        String name = productDto.getName();
        String description = productDto.getDescription();
        Double price = productDto.getPrice();
        Double prevPrice = productDto.getPrevPrice();
        Subcategory subcategory = subcategoryRepository.findById(productDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productDto.getShopId())));
        Product product = new Product(name,description,price,prevPrice,subcategory,shop);
        return productRepository.save(product);
    }

    @Override
    public Product update(Long productId, ProductDto productDto) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
        Subcategory subcategory = subcategoryRepository.findById(productDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productDto.getShopId())));
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setPrevPrice(productDto.getPrevPrice());
        product.setSubcategory(subcategory);
        product.setShop(shop);
        return productRepository.save(product);
    }

    @Override
    public Product findById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void deleteById(Long productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Set<Review> getReviews(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
        return product.getReviews();
    }

    @Override
    public Set<Purchase> getPurchases(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
        return product.getPurchases();
    }
}
