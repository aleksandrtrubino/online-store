package ru.vistar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @Column(name = "product_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    private Subcategory subcategory;

    @OneToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "prev_price")
    private Double prevPrice;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at" ,columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Product(){}

    public Product(Subcategory subcategory, Shop shop, String name, String description, Double price, Double prevPrice) {
        this.subcategory = subcategory;
        this.shop = shop;
        this.name = name;
        this.description = description;
        this.price = price;
        this.prevPrice = prevPrice;
    }

    public Long getId() {
        return id;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}
