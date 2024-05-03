package ru.vistar.kionmarket.mapper;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.dto.ProductResponseDto;

import java.util.List;

public interface ProductMapper {

    ProductResponseDto toDto(Product product);
    List<ProductResponseDto> toDto(List<Product> products);
}
