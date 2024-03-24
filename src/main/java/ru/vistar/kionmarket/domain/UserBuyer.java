package ru.vistar.kionmarket.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "buyers")
@PrimaryKeyJoinColumn(name = "user_id")
public class UserBuyer extends User {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    Address address;

    public UserBuyer() {
    }

    public UserBuyer(String password, String email, String firstName, String middleName, String lastName, Address address) {
        super(password, email, firstName, middleName, lastName);
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
