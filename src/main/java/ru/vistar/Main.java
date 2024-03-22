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

//        User user = new User();
//        user.setEmail("string1234@mail.com");
//        user.setPassword("4321");
//        user.setEnabled(true);
//        user.setFirstName("Иван");
//        user.setMiddleName("Иванович");
//        user.setLastName("Иванов");
//
//        Authority authority = new Authority();
//        authority.setName("admin");
//
//        Set<Authority> authorities = new HashSet<>();
//        authorities.add(authority);
//
//        user.setAuthorities(authorities);
//
//
//        City city = new City("voronezh");
//        Street street = new Street("voroshilova");
//        House house = new House("49");
//
//        Address address = new Address(city, street, house);
//
//
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
//
//        PurchaseStatus purchaseStatus = new PurchaseStatus("is_done");
//
//        Purchase purchase = new Purchase();
//        purchase.setUser(user);
//        purchase.setAddress(address);
//        purchase.setProduct(product);
//        purchase.setPurchaseStatus(purchaseStatus);
//        purchase.setCreatedAt(LocalDateTime.now());
//        purchase.setUpdatedAt(LocalDateTime.now());



        entityManager.getTransaction().begin();
        User user = entityManager.getReference(User.class, 1101L);
        System.out.println(user.getReviews().get(0).getId());
//        entityManager.persist(user);
//        entityManager.persist(authority);
//
//        entityManager.persist(city);
//        entityManager.persist(street);
//        entityManager.persist(house);
//        entityManager.persist(address);
//
//        entityManager.persist(shop);
//        entityManager.persist(category);
//        entityManager.persist(subcategory);
//        entityManager.persist(product);
//
//        entityManager.persist(purchaseStatus);
//
//        entityManager.persist(purchase);

        entityManager.getTransaction().commit();
    }
}