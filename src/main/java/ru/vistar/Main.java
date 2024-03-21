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

//        Shop shop = new Shop();
//        shop.setName("Спортмастер");
//
//        Category category = new Category();
//        category.setName("Спорттовары");
//
//        Subcategory subcategory = new Subcategory();
//        subcategory.setName("Товары для футбола");
//        subcategory.setCategory(category);
//
//        Product product = new Product();
//        product.setName("Футбольный мяч");
//        product.setDescription("Футбольный мяч прочный хороший");
//        product.setPrice(100.0);
//        product.setPrevPrice(null);
//        product.setShop(shop);
//        product.setSubcategory(subcategory);
        User user = new User();

        entityManager.getTransaction().begin();
//        entityManager.persist(shop);
//        entityManager.persist(category);
//        entityManager.persist(subcategory);
//        entityManager.persist(product);
        entityManager.getTransaction().commit();

    }
}