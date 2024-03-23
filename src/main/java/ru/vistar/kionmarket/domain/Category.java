package ru.vistar.kionmarket.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Subcategory> subcategories;

    public Category(){}

    public Category(String name) {
        this.name = name;
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

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subategories) {
        this.subcategories = subategories;
    }
}
