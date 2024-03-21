package ru.vistar;

import javax.persistence.*;

@Entity(name = "subcategories")
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "subcategories_seq")
    @Column(name = "subcategory_id")
    private Long id;

    @Column(name = "subcategory_name")
    private String name;

    @OneToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    Category category;

    public Subcategory(){}

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
