package ru.vistar.kionmarket.user.authority;

import ru.vistar.kionmarket.user.User;

import jakarta.persistence.*;
import java.util.Set;

@Entity(name = "authorities")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authorities_seq")
    @Column(name = "authority_id")
    private Long id;
    @Column(name = "authority_name")
    private String name;
    @ManyToMany(mappedBy = "authorities")
    private Set<User> users;

    public Authority() {}

    public Authority(String name) {
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

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
