package ru.vistar.kionmarket.user.supplier;

import ru.vistar.kionmarket.shop.Shop;
import ru.vistar.kionmarket.user.User;

import jakarta.persistence.*;

@Entity(name = "suppliers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Supplier extends User {

    @OneToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    Shop shop;

    public Supplier(){}

    public Supplier(String password, String email, String firstName, String middleName, String lastName, Shop shop){
        super(password, email, firstName, middleName, lastName);
        this.shop = shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }
}
