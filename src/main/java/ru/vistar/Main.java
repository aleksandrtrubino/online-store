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

        City city = new City("voronezh");
        Street street = new Street("voroshilova");
        House house1 = new House("49");
        House house2 = new House("40");

        Address address1 = new Address(city, street, house1);
        Address address2 = new Address(city, street, house2);
        Supplier supplier = new Supplier();
        supplier.setEmail("pterov@mail.com");
        supplier.setPassword("1234");
        supplier.setEnabled(true);
        supplier.setFirstName("Петр");
        supplier.setMiddleName("Петрович");
        supplier.setLastName("Петров");
        Shop shop = new Shop();
        shop.setName("Пятерочка");
        supplier.setShop(shop);

        entityManager.getTransaction().begin();
        entityManager.persist(city);
        entityManager.persist(street);
        entityManager.persist(house1);
        entityManager.persist(house2);
        entityManager.persist(address1);
        entityManager.persist(address2);
        entityManager.getTransaction().commit();

    }
}