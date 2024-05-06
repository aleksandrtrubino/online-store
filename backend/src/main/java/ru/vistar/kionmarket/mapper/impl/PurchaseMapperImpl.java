package ru.vistar.kionmarket.mapper.impl;

import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.ProductResponseDto;
import ru.vistar.kionmarket.dto.PurchaseResponseDto;
import ru.vistar.kionmarket.mapper.ProductMapper;
import ru.vistar.kionmarket.mapper.PurchaseMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class PurchaseMapperImpl implements PurchaseMapper {

    private final ProductMapper productMapper;

    public PurchaseMapperImpl(ProductMapperImpl productMapper){
        this.productMapper = productMapper;
    }


    @Override
    public PurchaseResponseDto toDto(Purchase purchase) {
        Long id = purchase.getId();
        User user = purchase.getUser();
        Address address = purchase.getAddress();
        ProductResponseDto product = productMapper.toDto(purchase.getProduct());
        PurchaseStatus status = purchase.getPurchaseStatus();
        LocalDateTime createdAt = purchase.getCreatedAt();
        LocalDateTime updatedAt = purchase.getUpdatedAt();
        return new PurchaseResponseDto(id, user, address, product, status, createdAt, updatedAt);
    }

    @Override
    public List<PurchaseResponseDto> toDto(List<Purchase> purchases) {
        List<PurchaseResponseDto> responseDtos = new ArrayList<>();
        for(Purchase purchase : purchases){
            PurchaseResponseDto responseDto = toDto(purchase);
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }
}
