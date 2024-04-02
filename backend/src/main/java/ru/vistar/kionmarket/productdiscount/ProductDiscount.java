package ru.vistar.kionmarket.productdiscount;

import jakarta.persistence.*;
import ru.vistar.kionmarket.product.Product;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_discounts")
public class ProductDiscount {
    @Id
    @Column(name = "product_discount_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_discount_seq")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Column(name = "discount_value")
    private int value;
    @Column(name = "start_date")
    private LocalDateTime start;
    @Column(name = "end_date")
    private LocalDateTime end;

    public ProductDiscount(){}

    public ProductDiscount(Product product, int value, LocalDateTime start, LocalDateTime end) {
        this.product = product;
        this.value = value;
        this.start = start;
        this.end = end;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
