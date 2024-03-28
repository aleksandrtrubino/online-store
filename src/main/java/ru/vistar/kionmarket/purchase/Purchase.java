package ru.vistar.kionmarket.purchase;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;
import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.purchasestatus.PurchaseStatus;
import ru.vistar.kionmarket.user.User;
import ru.vistar.kionmarket.product.Product;

import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @Column(name = "purchase_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchases_seq")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "purchase_status_id", referencedColumnName = "purchase_status_id")
    private PurchaseStatus purchaseStatus;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at",columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    public Purchase(){}

    public Purchase(User user, Address address, Product product, PurchaseStatus purchaseStatus) {
        this.user = user;
        this.address = address;
        this.product = product;
        this.purchaseStatus = purchaseStatus;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public PurchaseStatus getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }


}
