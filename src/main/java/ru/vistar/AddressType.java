package ru.vistar;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "address_types")
public class AddressType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_types_seq")
    @Column(name = "address_type_id")
    private Long id;

    @Column(name = "address_type_name")
    private String name;

    @OneToMany(mappedBy = "addressType")
    private List<Address> addresses;

    public AddressType(){}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }
}
