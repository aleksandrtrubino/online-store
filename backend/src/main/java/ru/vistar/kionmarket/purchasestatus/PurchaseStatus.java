package ru.vistar.kionmarket.purchasestatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.vistar.kionmarket.purchase.Purchase;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "purchase_statuses")
public class PurchaseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_statuses_seq")
    @Column(name = "purchase_status_id")
    private Long id;

    @Column(name = "purchase_status_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "purchaseStatus", fetch = FetchType.LAZY)
    Set<Purchase> purchases;

    public PurchaseStatus(){}

    public PurchaseStatus(String name) {
        this.name = name;
        this.purchases = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Purchase> purchases) {
        this.purchases = purchases;
    }
}


