package ru.vistar.kionmarket.product;

import org.hibernate.query.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
