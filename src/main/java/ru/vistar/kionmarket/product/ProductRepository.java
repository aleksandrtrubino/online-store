package ru.vistar.kionmarket.product;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.product.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
