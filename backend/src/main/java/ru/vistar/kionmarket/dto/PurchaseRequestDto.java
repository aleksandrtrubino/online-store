package ru.vistar.kionmarket.dto;

public class PurchaseRequestDto {
    private Long userId;
    private Long addressId;
    private Long productId;
    private Long purchaseStatusId;

    public PurchaseRequestDto() {
    }

    public PurchaseRequestDto(Long userId, Long addressId, Long productId, Long purchaseStatusId) {
        this.userId = userId;
        this.addressId = addressId;
        this.productId = productId;
        this.purchaseStatusId = purchaseStatusId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getPurchaseStatusId() {
        return purchaseStatusId;
    }

    public void setPurchaseStatusId(Long purchaseStatusId) {
        this.purchaseStatusId = purchaseStatusId;
    }
}
