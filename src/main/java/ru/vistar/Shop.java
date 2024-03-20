package ru.vistar;

import javax.persistence.*;

@Entity(name = "shops")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "shops_seq")
    @Column(name = "shop_id")
    private long id;

    @Column(name = "shop_name")
    private String name;

    public Shop(){}

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
