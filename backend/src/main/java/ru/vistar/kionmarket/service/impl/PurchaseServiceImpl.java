package ru.vistar.kionmarket.service.impl;

import io.micrometer.common.lang.Nullable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.PurchaseStatus;
import ru.vistar.kionmarket.domain.User;
import ru.vistar.kionmarket.dto.PurchaseRequestDto;
import ru.vistar.kionmarket.dto.PurchaseResponseDto;
import ru.vistar.kionmarket.mapper.PurchaseMapper;
import ru.vistar.kionmarket.mapper.impl.PurchaseMapperImpl;
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
    private final PurchaseMapper purchaseMapper;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository, UserRepository userRepository, AddressRepository addressRepository, ProductRepository productRepository, PurchaseStatusRepository purchaseStatusRepository, PurchaseMapperImpl purchaseMapper) {
        this.purchaseRepository = purchaseRepository;
        this.userRepository = userRepository;
        this.addressRepository = addressRepository;
        this.productRepository = productRepository;
        this.purchaseStatusRepository = purchaseStatusRepository;
        this.purchaseMapper = purchaseMapper;
    }

    @Override
    public PurchaseResponseDto create(PurchaseRequestDto purchaseRequestDto) {
        Long userId = purchaseRequestDto.getUserId();
        Long addressId = purchaseRequestDto.getAddressId();
        Long productId = purchaseRequestDto.getProductId();
        Long purchaseStatusId = purchaseRequestDto.getPurchaseStatusId();
        User user = userRepository.findById(purchaseRequestDto.getUserId())
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
        return purchaseMapper.toDto(purchaseRepository.save(purchase));

    }

    @Override
    public PurchaseResponseDto update(Long purchaseId, PurchaseRequestDto purchaseRequestDto) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase with id %1$s not found",purchaseId)));
        Long userId = purchaseRequestDto.getUserId();
        Long addressId = purchaseRequestDto.getAddressId();
        Long productId = purchaseRequestDto.getProductId();
        Long purchaseStatusId = purchaseRequestDto.getPurchaseStatusId();
        User user = userRepository.findById(purchaseRequestDto.getUserId())
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
        return purchaseMapper.toDto(purchaseRepository.save(purchase));
    }

    @Override
    public PurchaseResponseDto findById(Long purchaseId) {
        return purchaseMapper.toDto(purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase with id %1$s not found",purchaseId))));
    }

    @Override
    public List<PurchaseResponseDto> findAllByPurchaseStatusId(Long purchaseStatusId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = Long.parseLong(userDetails.getUsername());
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException(String.format("User with id %1$s not found", userId));

        Sort sort = Sort.by(Sort.Direction.DESC, "updatedAt");
        return purchaseMapper.toDto(purchaseRepository.findAllByUserIdAndPurchaseStatusId(userId, purchaseStatusId, sort));
    }

    @Override
    public void deleteById(Long purchaseId) {
        purchaseRepository.deleteById(purchaseId);
    }

    @Override
    public void delete(
            Long productId,
            Long purchaseStatusId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Long userId = Long.parseLong(userDetails.getUsername());
        if(!userRepository.existsById(userId))
            throw new ResourceNotFoundException(String.format("User with id %1$s not found", userId));
        Specification<Purchase> spec = Specification.where(null);
        spec = spec
                .and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("user").get("id"), userId))
                .and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("product").get("id"), productId))
                .and((root, query, criteriaBuilder) ->
                        criteriaBuilder.equal(root.get("purchaseStatus").get("id"), purchaseStatusId));

        purchaseRepository.findAll(spec).stream().findFirst().ifPresent(purchaseRepository::delete);
    }

    @Override
    public PurchaseResponseDto patch(Long purchaseId, @Nullable PurchaseRequestDto purchaseRequestDto) {
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Purchase with id %1$s not found",purchaseId)));

        if(purchaseRequestDto != null){
            Long userId = purchaseRequestDto.getUserId();
            Long addressId = purchaseRequestDto.getAddressId();
            Long productId = purchaseRequestDto.getProductId();
            Long purchaseStatusId = purchaseRequestDto.getPurchaseStatusId();

            if(userId != null){
                User user = userRepository.findById(purchaseRequestDto.getUserId())
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
            return purchaseMapper.toDto(purchaseRepository.save(purchase));
        }
        else
            return purchaseMapper.toDto(purchase);

    }
}
