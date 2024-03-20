package ru.vistar;

import javax.persistence.*;

@Entity(name = "suppliers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Supplier extends User{

    @OneToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    Shop shop;

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Shop getShop() {
        return shop;
    }
}
