package ru.vistar.kionmarket.product;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.productdiscount.ProductDiscount;
import ru.vistar.kionmarket.productdiscount.ProductDiscountRepository;
import ru.vistar.kionmarket.productprice.ProductPrice;
import ru.vistar.kionmarket.productprice.ProductPriceRepository;

import java.util.List;

@Component
@EnableScheduling
public class ProductUpdateScheduledTask {

    private final int UPDATE_PRICE_INTERVAL = 300000;
    private final int UPDATE_DISCOUNT_INTERVAL = 300000;

    private final ProductRepository productRepository;
    private final ProductPriceRepository productPriceRepository;
    private final ProductDiscountRepository productDiscountRepository;

    public ProductUpdateScheduledTask(
            ProductRepository productRepository,
            ProductPriceRepository productPriceRepository,
            ProductDiscountRepository productDiscountRepository) {
        this.productRepository = productRepository;
        this.productPriceRepository = productPriceRepository;
        this.productDiscountRepository = productDiscountRepository;
    }

    @Scheduled(fixedRate = UPDATE_PRICE_INTERVAL)
    public void updatePrice(){
        List<ProductPrice> actualPrices = productPriceRepository.getActualPrices();
        for(ProductPrice price : actualPrices){
            Long productId = price.getProduct().getId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
            product.setPrice(price);
            productRepository.save(product);
        }
    }

    @Scheduled(fixedRate = UPDATE_DISCOUNT_INTERVAL)
    public void updateDiscount(){
        List<ProductDiscount> actualDiscounts = productDiscountRepository.getActualDiscounts();
        for(ProductDiscount discount : actualDiscounts){
            Long productId = discount.getProduct().getId();
            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new ResourceNotFoundException(String.format("Product with id %1$s not found", productId)));
            product.setDiscount(discount);
            productRepository.save(product);
        }
    }

}
