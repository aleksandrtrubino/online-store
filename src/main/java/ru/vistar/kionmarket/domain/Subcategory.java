package ru.vistar.kionmarket.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.vistar.kionmarket.domain.Category;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "subcategories")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategories_seq")
    @Column(name = "subcategory_id")
    private Long id;

    @Column(name = "subcategory_name")
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subcategory", fetch = FetchType.LAZY)
    private Set<Product> products;
    public Subcategory(){}

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
