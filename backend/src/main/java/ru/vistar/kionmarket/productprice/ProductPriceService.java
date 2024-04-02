package ru.vistar.kionmarket.productprice;

import ru.vistar.kionmarket.product.ProductDto;

import java.util.List;

//product-prices
public interface ProductPriceService {
    public ProductPrice create(ProductPriceDto productPriceDto);// POST
    public ProductPrice update(Long productPriceId, ProductPriceDto productPriceDto);//{productPriceId} PUT
    public ProductPrice findById(Long productPriceId);//{productPriceId} GET
    public List<ProductPrice> findAll();// GET
    public void deleteById(Long productPriceId);//{productPriceId} DELETE

}
