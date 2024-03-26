package ru.vistar.kionmarket.address;

import jakarta.persistence.*;
import ru.vistar.kionmarket.addresstype.AddressType;
import ru.vistar.kionmarket.city.City;
import ru.vistar.kionmarket.house.House;
import ru.vistar.kionmarket.street.Street;

@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "addresses_seq")
    @Column(name = "address_id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "city_id", referencedColumnName = "city_id")
    private City city;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "street_id", referencedColumnName = "street_id")
    private Street street;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id", referencedColumnName = "house_id")
    private House house;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "address_type_id",referencedColumnName = "address_type_id")
    private AddressType addressType;


    public Address(){}

    public Address(City city, Street street, House house, AddressType addressType) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.addressType = addressType;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public Street getStreet() {
        return street;
    }

    public void setStreet(Street street) {
        this.street = street;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
