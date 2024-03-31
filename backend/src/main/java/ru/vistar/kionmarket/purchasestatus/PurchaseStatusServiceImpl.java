package ru.vistar.kionmarket.purchasestatus;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.purchase.PurchaseRepository;

import java.util.List;
import java.util.Set;

@Service
public class PurchaseStatusServiceImpl implements PurchaseStatusService {

    private final PurchaseStatusRepository purchaseStatusRepository;

    public PurchaseStatusServiceImpl(PurchaseStatusRepository purchaseStatusRepository) {
        this.purchaseStatusRepository = purchaseStatusRepository;
    }

    @Override
    public PurchaseStatus create(PurchaseStatusDto purchaseStatusDto) {
        String name = purchaseStatusDto.getName();
        PurchaseStatus purchaseStatus = new PurchaseStatus(name);
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
