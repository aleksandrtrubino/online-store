package ru.vistar.kionmarket.productdiscount;

import java.time.LocalDateTime;

public class ProductDiscountDto {
    private int value;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long productId;
    public ProductDiscountDto(){}

    public ProductDiscountDto(int value, LocalDateTime start, LocalDateTime end, Long productId) {
        this.value = value;
        this.start = start;
        this.end = end;
        this.productId = productId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
