package ru.vistar;

import javax.persistence.*;

@Entity
@Table(name = "streets")
public class Street {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "streets_seq")
    @Column(name = "street_id")
    private Long id;

    @Column(name = "street_name")
    private String name;

    public Street(){}
    public Street(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
