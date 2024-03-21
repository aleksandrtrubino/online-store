package ru.vistar;

import javax.persistence.*;

@Entity
@Table(name = "favorites")
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user_id;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product_id;

    public Favorite(){}

    public User getUser_id() {
        return user_id;
    }

    public Product getProduct_id() {
        return product_id;
    }
}
