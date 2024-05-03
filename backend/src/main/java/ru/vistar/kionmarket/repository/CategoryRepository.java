package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
