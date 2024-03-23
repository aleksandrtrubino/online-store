package ru.vistar.kionmarket.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @Column(name = "product_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    private Subcategory subcategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price",columnDefinition = "NUMERIC(19,4)")
    private Double price;

    @Column(name = "prev_price",columnDefinition = "NUMERIC(19,4)")
    private Double prevPrice;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at" ,columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Review> reviews;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private List<Purchase> purchases;

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

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }
}
