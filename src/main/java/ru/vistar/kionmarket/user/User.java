package ru.vistar.kionmarket.user;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.*;
import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.authority.Authority;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.shop.Shop;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
    @Column(name = "user_id")
    private Long id;
    private String email;
    private String password;
    private Boolean enabled;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @CreationTimestamp
    @Column(name = "created_at",columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at" ,columnDefinition = "TIMESTAMP")
    private LocalDateTime updatedAt;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "users_authorities",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "authority_id"))
    private Set<Authority> authorities;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "favorites",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "product_id"))
    private Set<Product> favorites;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Purchase> purchases;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private Set<Review> reviews;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shop_id",referencedColumnName = "shop_id")
    private Shop shop;


    public User(){}

    public User( String email, String password, String firstName, String middleName, String lastName) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.enabled = true;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
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

