package ru.vistar.kionmarket.productprice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.vistar.kionmarket.product.Product;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_prices")
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_prices_seq")
    @Column(name = "product_price_id")
    private Long id;

    @JsonIgnore
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "product_price", columnDefinition = "NUMERIC(19,4)")
    private Double price;

    @Column(name = "change_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime changeDate;

    public ProductPrice() {}

    public ProductPrice(Product product, Double price, LocalDateTime changeDate) {
        this.product = product;
        this.price = price;
        this.changeDate = changeDate;
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }
}
