package ru.vistar;

import javax.persistence.*;

@Entity(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "products_seq")
    @Column(name = "product_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "subcategory_id", referencedColumnName = "subcategory_id")
    private Subcategory subcategory;

    @OneToOne
    @JoinColumn(name = "shop_id", referencedColumnName = "shop_id")
    private Shop shop;

    @Column(name = "product_name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "prev_price")
    private Double prevPrice;

    public Product(){}

    public Long getId() {
        return id;
    }

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrevPrice() {
        return prevPrice;
    }

    public void setPrevPrice(Double prevPrice) {
        this.prevPrice = prevPrice;
    }
}
