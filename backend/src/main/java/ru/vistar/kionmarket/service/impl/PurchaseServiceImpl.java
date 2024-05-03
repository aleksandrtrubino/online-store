package ru.vistar.kionmarket.service.impl;

import io.micrometer.common.lang.Nullable;
import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.PurchaseStatus;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.PurchaseDto;
import ru.vistar.kionmarket.service.PurchaseService;
import ru.vistar.kionmarket.repository.AddressRepository;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.repository.ProductRepository;
import ru.vistar.kionmarket.repository.PurchaseRepository;
import ru.vistar.kionmarket.repository.PurchaseStatusRepository;
import ru.vistar.kionmarket.repository.UserRepository;

import java.util.List;


@Service
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UserRepository userRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final PurchaseStatusRepository purchaseStatusRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, UserRepository userRepository, AddressRepository addressRepository, ProductRepository productRepository, PurchaseStatusRepository purchaseStatusRepository) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.purchaseStatusRepository = purchaseStatusRepository;
    }

    @Override
    public Purchase create(PurchaseDto purchaseDto) {
        Long userId = purchaseDto.getUserId();
        Long addressId = purchaseDto.getAddressId();
        Long productId = purchaseDto.getProductId();
        Long purchaseStatusId = purchaseDto.getPurchaseStatusId();
        User user = userRepository.findById(purchaseDto.getUserId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
        Address address;
        if(addressId != null)
        address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Address with id %1$s not found",addressId)));
        else
            address = null;
        Product product = productRepository.findById(productId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found",productId)));
        PurchaseStatus purchaseStatus = purchaseStatusRepository.findById(purchaseStatusId)
                    .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));

        Purchase purchase = new Purchase(user, address, product, purchaseStatus);
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

    @Override
    public Purchase patch(Long purchaseId,@Nullable PurchaseDto purchaseDto) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase with id %1$s not found",purchaseId)));

        if(purchaseDto != null){
            Long userId = purchaseDto.getUserId();
            Long addressId = purchaseDto.getAddressId();
            Long productId = purchaseDto.getProductId();
            Long purchaseStatusId = purchaseDto.getPurchaseStatusId();

            if(userId != null){
                User user = userRepository.findById(purchaseDto.getUserId())
                        .orElseThrow(()->new ResourceNotFoundException(String.format("User with id %1$s not found",userId)));
                purchase.setUser(user);
            }
            if(addressId != null){
                Address address = addressRepository.findById(addressId)
                        .orElseThrow(()->new ResourceNotFoundException(String.format("Address with id %1$s not found",addressId)));
                purchase.setAddress(address);
            }
            if(productId != null){
                Product product = productRepository.findById(productId)
                        .orElseThrow(()->new ResourceNotFoundException(String.format("Product with id %1$s not found",productId)));
                purchase.setProduct(product);
            }
            if(purchaseStatusId != null){
                PurchaseStatus purchaseStatus = purchaseStatusRepository.findById(purchaseStatusId)
                        .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase status with id %1$s not found",purchaseStatusId)));
                purchase.setPurchaseStatus(purchaseStatus);
            }
            return purchaseRepository.save(purchase);
        }
        else
            return purchase;

    }
}
