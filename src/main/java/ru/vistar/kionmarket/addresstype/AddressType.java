package ru.vistar.kionmarket.addresstype;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vistar.kionmarket.address.Address;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "address_types")
public class AddressType {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_types_seq")
    @Column(name = "address_type_id")
    private Long id;

    @Column(name = "address_type_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "addressType", fetch = FetchType.LAZY)
    private Set<Address> addresses;

    public AddressType(){}

    public AddressType(String name) {
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

    public Set<Address> getAddresses() {
        return addresses;
    }

}
