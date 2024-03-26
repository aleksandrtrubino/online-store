package ru.vistar.kionmarket.subcategory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.subcategory.Subcategory;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
}
