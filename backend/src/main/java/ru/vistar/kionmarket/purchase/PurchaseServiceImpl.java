package ru.vistar.kionmarket.purchase;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.address.AddressRepository;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.product.ProductRepository;
import ru.vistar.kionmarket.purchasestatus.PurchaseStatus;
import ru.vistar.kionmarket.purchasestatus.PurchaseStatusRepository;
import ru.vistar.kionmarket.user.User;
import ru.vistar.kionmarket.user.UserRepository;

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
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Address with id %1$s not found",addressId)));
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
}
