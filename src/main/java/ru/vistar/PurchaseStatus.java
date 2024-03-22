package ru.vistar;

import javax.persistence.*;

@Entity
@Table(name = "purchase_statuses")
public class PurchaseStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "purchase_statuses_seq")
    @Column(name = "purchase_status_id")
    private Long id;

    @Column(name = "purchase_status_name")
    private String name;

    public PurchaseStatus(){}

    public PurchaseStatus(String name) {
        this.name = name;
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
}


