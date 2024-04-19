package ru.vistar.kionmarket.productprice;

import java.time.LocalDateTime;

public class ProductPriceDto {

    private Long productId;
    private Double price;
    private LocalDateTime changeDate;

    public ProductPriceDto(Long productId, Double price, LocalDateTime changeDate) {
        this.productId = productId;
        this.price = price;
        this.changeDate = changeDate;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }
}
