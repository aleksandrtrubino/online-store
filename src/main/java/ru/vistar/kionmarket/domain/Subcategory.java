package ru.vistar.kionmarket.domain;

import ru.vistar.kionmarket.domain.Category;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategories")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategories_seq")
    @Column(name = "subcategory_id")
    private Long id;

    @Column(name = "subcategory_name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    public Subcategory(){}

    public Subcategory(String name, Category category) {
        this.name = name;
        this.category = category;
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
}
