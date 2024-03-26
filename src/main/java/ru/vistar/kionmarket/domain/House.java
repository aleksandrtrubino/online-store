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
    public House(){}
    public House(String number) {
        this.number = number;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}