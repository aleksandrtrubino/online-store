package ru.vistar.kionmarket.mapper;

import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.PurchaseResponseDto;

import java.util.List;

public interface PurchaseMapper {

    PurchaseResponseDto toDto(Purchase purchase);
    List<PurchaseResponseDto> toDto(List<Purchase> purchases);
}