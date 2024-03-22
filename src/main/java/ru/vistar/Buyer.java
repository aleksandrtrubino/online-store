package ru.vistar;

import javax.persistence.*;

@Entity(name = "buyers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Buyer extends User{

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    Address address;

    public Buyer(){}

    public Buyer(String password, String email, String firstName, String middleName, String lastName, Address address) {
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
