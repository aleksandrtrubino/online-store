package ru.vistar.kionmarket.productprice;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.product.ProductRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductPriceServiceImpl implements ProductPriceService{

    private final ProductPriceRepository productPriceRepository;
    private final ProductRepository productRepository;

    public ProductPriceServiceImpl(ProductPriceRepository productPriceRepository, ProductRepository productRepository) {
        this.productPriceRepository = productPriceRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductPrice create(ProductPriceDto productPriceDto) {
        Product product = productRepository.findById(productPriceDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productPriceDto.getProductId())));
        Long price = productPriceDto.getPrice();
        LocalDateTime changeDate = productPriceDto.getChangeDate();
        ProductPrice productPrice = new ProductPrice(product, price, changeDate);
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice update(Long productPriceId, ProductPriceDto productPriceDto) {
        ProductPrice productPrice = productPriceRepository.findById(productPriceId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product price with id %1$s not found", productPriceId)));
        Product product = productRepository.findById(productPriceDto.getProductId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productPriceDto.getProductId())));
        productPrice.setProduct(product);
        productPrice.setPrice(productPriceDto.getPrice());
        productPrice.setChangeDate(productPriceDto.getChangeDate());
        return productPriceRepository.save(productPrice);
    }

    @Override
    public ProductPrice findById(Long productPriceId) {
        return productPriceRepository.findById(productPriceId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Product price with id %1$s not found", productPriceId)));
    }

    @Override
    public List<ProductPrice> findAll() {
        return productPriceRepository.findAll();
    }

    @Override
    public void deleteById(Long productPriceId) {
        productPriceRepository.deleteById(productPriceId);
    }
}
