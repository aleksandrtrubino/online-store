package ru.vistar.kionmarket.product;

public class ProductDto {

    private String name;
    private String description;
    private Double price;
    private Double prevPrice;
    private Long subcategoryId;
    private Long shopId;

    public ProductDto(){}

    public ProductDto(String name, String description, Double price, Double prevPrice, Long subcategoryId, Long shopId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.prevPrice = prevPrice;
        this.subcategoryId = subcategoryId;
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(Double prevPrice) {
        this.prevPrice = prevPrice;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
