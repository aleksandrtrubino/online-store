package ru.vistar.kionmarket.productprice;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(name = "product_price", columnDefinition = "NUMERIC(19,4)")
    private Long price;

    @Column(name = "change_date",columnDefinition = "TIMESTAMP")
    private LocalDateTime changeDate;

    public ProductPrice() {}

    public ProductPrice(Product product, Long price, LocalDateTime changeDate) {
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

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public LocalDateTime getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDateTime changeDate) {
        this.changeDate = changeDate;
    }
}
