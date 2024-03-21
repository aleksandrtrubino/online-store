package ru.vistar;

import javax.persistence.*;

@Entity
@Table(name = "pickup_points")
public class PickupPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pickup_point_seq")
    @Column(name = "pickup_point_id")
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", referencedColumnName = "address_id")
    private Address address;

    PickupPoint(){}

    public PickupPoint(Address address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
