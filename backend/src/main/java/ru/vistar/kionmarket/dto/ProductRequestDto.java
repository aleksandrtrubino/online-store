package ru.vistar.kionmarket.dto;

public class ProductRequestDto {

    private String name;
    private String description;
    private Long subcategoryId;
    private Long shopId;

    public ProductRequestDto(){}

    public ProductRequestDto(String name, String description, Long subcategoryId, Long shopId) {
        this.name = name;
        this.description = description;
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
