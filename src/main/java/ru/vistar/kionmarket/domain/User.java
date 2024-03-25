package ru.vistar.kionmarket.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.vistar.kionmarket.domain.Authority;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.Review;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @Column(name = "user_id")
    private Long id;
    private String password;
    private String email;
    private Boolean enabled = true;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_authorities",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "authority_id", referencedColumnName = "authority_id"))
    private Set<Authority> authorities;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id",referencedColumnName = "shop_id")
    private Shop shop;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "favorites",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "product_id", referencedColumnName = "product_id"))
    private Set<Product> favorites;

    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Column(name = "updated_at" ,columnDefinition = "TIMESTAMP")
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Review> reviews;


    public User(){}

    public User(String password, String email, String firstName, String middleName, String lastName) {
        this.password = password;
        this.email = email;
        this.enabled = true;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Product> getFavorites() {
        return favorites;
    }

    public void setFavorites(Set<Product> favorites) {
        this.favorites = favorites;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

