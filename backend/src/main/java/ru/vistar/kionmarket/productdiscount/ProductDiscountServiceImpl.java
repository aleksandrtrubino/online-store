package ru.vistar.kionmarket.productdiscount;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.product.ProductRepository;

import java.util.List;
@Service
public class ProductDiscountServiceImpl implements ProductDiscountService{
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
        productDiscount.setStart(productDiscountDto.getStart());
        productDiscount.setEnd(productDiscountDto.getEnd());
        return productDiscountRepository.save(productDiscount);
    }

    @Override
    public ProductDiscount update(Long id, ProductDiscountDto productDiscountDto) {
        ProductDiscount productDiscount = productDiscountRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("ProductDiscount with id %1$s not found", id)));
        Product product = productRepository.findById(productDiscountDto.getProductId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found", productDiscountDto.getProductId())));
        productDiscount.setProduct(product);
        productDiscount.setValue(productDiscountDto.getValue());
        productDiscount.setStart(productDiscountDto.getStart());
        productDiscount.setEnd(productDiscountDto.getEnd());
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
