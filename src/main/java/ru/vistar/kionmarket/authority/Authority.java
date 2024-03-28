package ru.vistar.kionmarket.authority;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import ru.vistar.kionmarket.user.User;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_seq")
    @Column(name = "authority_id")
    private Long id;
    @Column(name = "authority_name")
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private Set<User> users;

    public Authority() {}

    public Authority(String name) {
        this.name = name;
        this.users = new HashSet<>();
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

    public Set<User> getUsers() {
        return users;
    }
}
