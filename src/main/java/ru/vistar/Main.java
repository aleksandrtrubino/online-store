package ru.vistar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws SQLException {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ru.vistar.persistence-unit");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = new User();
        user.setEmail("string1234@mail.com");
        user.setPassword("4321");
        user.setEnabled(true);

        Authority authority = new Authority();
        authority.setName("admin");

        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);

        user.setAuthorities(authorities);

        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.persist(authority);
        authority = entityManager.getReference(Authority.class,1151L);
        entityManager.getTransaction().commit();

    }
}