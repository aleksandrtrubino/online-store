package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.PurchaseStatus;
import ru.vistar.kionmarket.dto.PurchaseStatusDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.repository.PurchaseRepository;
import ru.vistar.kionmarket.repository.PurchaseStatusRepository;
import ru.vistar.kionmarket.service.PurchaseStatusService;

import java.util.List;
import java.util.Set;

@Service
public class PurchaseStatusServiceImpl implements PurchaseStatusService {

    final PurchaseStatusRepository purchaseStatusRepository;
    final PurchaseRepository purchaseRepository;

    public PurchaseStatusServiceImpl(PurchaseStatusRepository purchaseStatusRepository, PurchaseRepository purchaseRepository) {
        this.purchaseStatusRepository = purchaseStatusRepository;
        this.purchaseRepository = purchaseRepository;
    }

    @Override
    public PurchaseStatus create(PurchaseStatusDto purchaseStatusDto) {
        PurchaseStatus purchaseStatus = new PurchaseStatus();
        purchaseStatus.setName(purchaseStatusDto.getName());
        return purchaseStatusRepository.save(purchaseStatus);
    }

    @Override
    public PurchaseStatus update(Long purchaseStatusId, PurchaseStatusDto purchaseStatusDto) {
        PurchaseStatus purchaseStatus = purchaseStatusRepository.findById(purchaseStatusId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));
        purchaseStatus.setName(purchaseStatusDto.getName());
        return purchaseStatusRepository.save(purchaseStatus);
    }

    @Override
    public PurchaseStatus findById(Long purchaseStatusId) {
        return purchaseStatusRepository.findById(purchaseStatusId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));
    }

    @Override
    public List<PurchaseStatus> findAll() {
        return purchaseStatusRepository.findAll();
    }

    @Override
    public void deleteById(Long purchaseStatusId) {
        purchaseStatusRepository.deleteById(purchaseStatusId);
    }

    @Override
    public Set<Purchase> getPurchases(Long purchaseStatusId) {
        PurchaseStatus purchaseStatus = purchaseStatusRepository.findById(purchaseStatusId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));
        return purchaseStatus.getPurchases();
    }
}
