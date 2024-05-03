package ru.vistar.kionmarket.dto;

import java.time.LocalDateTime;

public class ProductDiscountDto {
    private Integer value;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long productId;
    public ProductDiscountDto(){}

    public ProductDiscountDto(Integer value, LocalDateTime startDate, LocalDateTime endDate, Long productId) {
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
        this.productId = productId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
