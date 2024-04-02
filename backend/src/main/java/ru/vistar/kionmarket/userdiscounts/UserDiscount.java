package ru.vistar.kionmarket.userdiscounts;

import jakarta.persistence.*;
import ru.vistar.kionmarket.user.User;

@Entity
@Table(name = "user_discounts")
public class UserDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_discount_seq")
    @Column(name = "user_discount_id")
    Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    User user;

    @Column(name = "discount_value")
    int value;

    public UserDiscount(){}
    public UserDiscount(User user, int value) {
        this.user = user;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
