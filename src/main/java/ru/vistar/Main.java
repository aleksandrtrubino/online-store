package ru.vistar;

import org.hibernate.type.LocalDateType;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws SQLException {

        final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ru.vistar.persistence-unit");
        final EntityManager entityManager = entityManagerFactory.createEntityManager();

//        Shop shop = new Shop();
//        shop.setName("Спортdмастер");
//
//        Category category = new Category();
//        category.setName("Спорттdовары");
//
//        Subcategory subcategory = new Subcategory();
//        subcategory.setName("Товаdры для футбола");
//        subcategory.setCategory(category);
//
//        Product product = new Product();
//        product.setName("Футбольнdый мяч");
//        product.setDescription("Футбdольный мяч прочный хороший");
//        product.setPrice(100.0);
//        product.setPrevPrice(null);
//        product.setShop(shop);
//        product.setSubcategory(subcategory);
//
//        User user = new User();
//        user.setEmail("sdtring1234@mail.com");
//        user.setPassword("43d21");
//        user.setEnabled(true);
//        user.setFirstName("Ивdан");
//        user.setMiddleName("Иваdнович");
//        user.setLastName("Иваноdв");
//        user.setFavorites(new HashSet<>());
//        user.getFavorites().add(product);
//
//        Review review = new Review(5,"good",user,product, LocalDateTime.now(),LocalDateTime.now());
//
        PurchaseStatus purchaseStatus = new PurchaseStatus("is_done");


        entityManager.getTransaction().begin();
//        entityManager.persist(shop);
//        entityManager.persist(category);
//        entityManager.persist(subcategory);
//        entityManager.persist(product);
//        entityManager.persist(user);
//        entityManager.persist(review);
            entityManager.persist(purchaseStatus);
        entityManager.getTransaction().commit();
    }
}