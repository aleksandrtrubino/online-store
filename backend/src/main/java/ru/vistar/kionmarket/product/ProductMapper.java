package ru.vistar.kionmarket.product;

import org.mapstruct.Mapper;

import java.util.List;

public interface ProductMapper {

    ProductResponseDto toDto(Product product);
    List<ProductResponseDto> toDto(List<Product> products);
}
