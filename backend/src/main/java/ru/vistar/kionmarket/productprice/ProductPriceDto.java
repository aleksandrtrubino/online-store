package ru.vistar.kionmarket.productprice;

import java.time.LocalDateTime;

public class ProductPriceDto {

    private Long productId;
    private Long price;
    private LocalDateTime changeDate;

    public ProductPriceDto(Long productId, Long price, LocalDateTime changeDate) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }
}
