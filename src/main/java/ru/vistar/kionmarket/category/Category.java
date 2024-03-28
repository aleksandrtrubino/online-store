package ru.vistar.kionmarket.category;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "categories_seq")
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private Set<Subcategory> subcategories;

    public Category(){}

    public Category(String name) {
        this.name = name;
        this.subcategories = new HashSet<>();
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

    public Set<Subcategory> getSubcategories() {
        return subcategories;
    }
}
