package ru.vistar.kionmarket.category;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.category.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
