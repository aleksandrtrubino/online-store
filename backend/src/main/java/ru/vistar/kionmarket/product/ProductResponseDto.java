package ru.vistar.kionmarket.product;

import ru.vistar.kionmarket.productdiscount.ProductDiscount;
import ru.vistar.kionmarket.productprice.ProductPrice;
import ru.vistar.kionmarket.shop.Shop;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.List;

public class ProductResponseDto {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer discount;
    private Boolean isDiscount;
    private Subcategory subcategory;
    private Shop shop;
    private List<byte[]> images;

    public ProductResponseDto(){}

    public ProductResponseDto(Long id, String name, String description, Double price, Subcategory subcategory, Shop shop, List<byte[]> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.subcategory = subcategory;
        this.shop = shop;
        this.isDiscount = false;
        this.images = images;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
            this.discount = discount;
    }

    public void setIsDiscount(Boolean discount) {
        isDiscount = discount;
    }

    public Boolean getIsDiscount(){
        return isDiscount;
    }

    public List<byte[]> getImages() {
        return images;
    }

    public void setImages(List<byte[]> images) {
        this.images = images;
    }
}
