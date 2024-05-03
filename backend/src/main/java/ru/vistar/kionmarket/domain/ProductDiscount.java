package ru.vistar.kionmarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_discounts")
public class ProductDiscount {
    @Id
    @Column(name = "product_discount_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "product_discount_seq")
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;
    @Column(name = "discount_value")
    private Integer value;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    public ProductDiscount(){}

    public ProductDiscount(Product product, Integer value, LocalDateTime startDate, LocalDateTime endDate) {
        this.product = product;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Integer getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime start) {
        this.startDate = start;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime end) {
        this.endDate = end;
    }
}
