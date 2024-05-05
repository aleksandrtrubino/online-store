package ru.vistar.kionmarket.dto;

import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.PurchaseStatus;
import ru.vistar.kionmarket.domain.User;

import java.time.LocalDateTime;

public class PurchaseResponseDto {
    Long id;
    User user;
    Address address;
    ProductResponseDto product;
    PurchaseStatus status;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public PurchaseResponseDto(Long id, User user, Address address, ProductResponseDto product, PurchaseStatus status, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.user = user;
        this.address = address;
        this.product = product;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }

    public PurchaseStatus getStatus() {
        return status;
    }

    public void setStatus(PurchaseStatus status) {
        this.status = status;
    }
}
