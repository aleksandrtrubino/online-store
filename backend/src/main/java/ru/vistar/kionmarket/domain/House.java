package ru.vistar.kionmarket.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "houses")
public class House {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "houses_seq")
    @Column(name = "house_id")
    private Long id;

    @Column(name = "house_number")
    private String number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    private Street street;
    public House(){}

    public House(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }
}
