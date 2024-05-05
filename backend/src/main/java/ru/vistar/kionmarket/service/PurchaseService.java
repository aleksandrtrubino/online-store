package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.dto.PurchaseRequestDto;
import ru.vistar.kionmarket.dto.PurchaseResponseDto;

import java.util.List;

//purchases
public interface PurchaseService {
    public PurchaseResponseDto create(PurchaseRequestDto purchaseRequestDto);// POST
    public PurchaseResponseDto update(Long purchaseId, PurchaseRequestDto purchaseRequestDto);//{purchaseId} PUT
    public PurchaseResponseDto findById(Long purchaseId);//{purchaseId} GET
    public List<PurchaseResponseDto> findAllByPurchaseStatusId(Long purchaseStatus);//?purchaseStatus={} GET
    public void deleteById(Long purchaseId);//{purchaseId} DELETE
    public void delete(Long productId, Long purchaseStatusId);//?productId={} DELETE
    public PurchaseResponseDto patch(Long purchaseId, PurchaseRequestDto purchaseRequestDto);//{purchaseId} PATCH
}
