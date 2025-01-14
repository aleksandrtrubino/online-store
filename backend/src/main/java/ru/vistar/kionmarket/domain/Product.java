package ru.vistar.kionmarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @Column(name = "product_id")
    private Long id;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_price_id",referencedColumnName = "product_price_id")
    private ProductPrice price;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_discount_id",referencedColumnName = "product_discount_id")
    private ProductDiscount discount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    private Subcategory subcategory;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at" ,columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @JsonIgnore
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    @JsonIgnore
    @ManyToMany(mappedBy = "favorites")
    private Set<User> usersAddedToFavorites;

    public Product(){}

    public Product(String name, String description, Subcategory subcategory, Shop shop) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
        this.shop = shop;
        this.reviews = new HashSet<>();
        this.purchases = new HashSet<>();
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

    public ProductPrice getPrice() {
        return price;
    }

    public void setPrice(ProductPrice price) {
        this.price = price;
    }

    public ProductDiscount getDiscount() {
        return discount;
    }

    public void setDiscount(ProductDiscount discount) {
        this.discount = discount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Set<User> getUsersAddedToFavorites() {
        return usersAddedToFavorites;
    }
}
