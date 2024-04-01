package ru.vistar.kionmarket.street;

import jakarta.persistence.*;
import ru.vistar.kionmarket.city.City;

@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "streets_seq")
    @Column(name = "street_id")
    private Long id;

    @Column(name = "street_name")
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;
    public Street(){}

    public Street(String name) {
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
