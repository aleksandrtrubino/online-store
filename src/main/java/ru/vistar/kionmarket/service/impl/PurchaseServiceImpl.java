package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.PurchaseDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.repository.*;
import ru.vistar.kionmarket.service.PurchaseService;

import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    final PurchaseRepository purchaseRepository;
    final UserRepository userRepository;
    final AddressRepository addressRepository;
    final ProductRepository productRepository;
    final PurchaseStatusRepository purchaseStatusRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, UserRepository userRepository, AddressRepository addressRepository, ProductRepository productRepository, PurchaseStatusRepository purchaseStatusRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.purchaseStatusRepository = purchaseStatusRepository;
    }

    @Override
    public Purchase create(PurchaseDto purchaseDto) {
        Purchase purchase = new Purchase();
        Long userId = purchaseDto.getUserId();
        Long addressId = purchaseDto.getAddressId();
        Long productId = purchaseDto.getProductId();
        Long purchaseStatusId = purchaseDto.getPurchaseStatusId();
        User user = userRepository.findById(purchaseDto.getUserId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Address with id %1$s not found",addressId)));
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found",productId)));
        PurchaseStatus purchaseStatus = purchaseStatusRepository.findById(purchaseStatusId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));
        purchase.setUser(user);
        purchase.setAddress(address);
        purchase.setProduct(product);
        purchase.setPurchaseStatus(purchaseStatus);
        return purchaseRepository.save(purchase);

    }

    @Override
    public Purchase update(Long purchaseId, PurchaseDto purchaseDto) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase with id %1$s not found",purchaseId)));
        Long userId = purchaseDto.getUserId();
        Long addressId = purchaseDto.getAddressId();
        Long productId = purchaseDto.getProductId();
        Long purchaseStatusId = purchaseDto.getPurchaseStatusId();
        User user = userRepository.findById(purchaseDto.getUserId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Address with id %1$s not found",addressId)));
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found",productId)));
        PurchaseStatus purchaseStatus = purchaseStatusRepository.findById(purchaseStatusId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));
        purchase.setUser(user);
        purchase.setAddress(address);
        purchase.setProduct(product);
        purchase.setPurchaseStatus(purchaseStatus);
        return purchaseRepository.save(purchase);
    }

    @Override
    public Purchase findById(Long purchaseId) {
        return purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase with id %1$s not found",purchaseId)));
    }

    @Override
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }

    @Override
    public void deleteById(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }
}