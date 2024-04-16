package ru.vistar.kionmarket.product;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.shop.ShopRepository;
import ru.vistar.kionmarket.subcategory.SubcategoryRepository;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.shop.Shop;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Set;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    private final SubcategoryRepository subcategoryRepository;

    private final String IMAGE_PATH = "src/main/resources/images";

    public ProductServiceImpl(ProductRepository productRepository, ShopRepository shopRepository, SubcategoryRepository subcategoryRepository) {
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
        this.subcategoryRepository = subcategoryRepository;
    }

    @Override
    public Product create(ProductDto productDto) {

        String name = productDto.getName();
        String description = productDto.getDescription();
        Subcategory subcategory = subcategoryRepository.findById(productDto.getSubcategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", productDto.getSubcategoryId())));
        Shop shop = shopRepository.findById(productDto.getShopId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Shop with id %1$s not found", productDto.getShopId())));
        Product product = new Product(name,description,subcategory,shop);

        String imageName = "product_" + product.getId();
        Path directoryPath = Path.of(IMAGE_PATH);
        Path imagePath = directoryPath.resolve(imageName);
        MultipartFile image = productDto.getImage();
        try {
            Files.copy(image.getInputStream(), imagePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        product.setImageName(imageName);

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
