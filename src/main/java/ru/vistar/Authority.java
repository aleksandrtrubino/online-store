package ru.vistar;

import javax.persistence.*;

@Entity(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_seq")
    @Column(name = "authority_id")
    private Long id;
    @Column(name = "authority_name")
    private String name;

    public Authority() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
