package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
