package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.ProductPrice;

import java.util.List;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {


    @Query(nativeQuery = true, value = """
        SELECT * FROM product_prices
        WHERE (product_id, change_date) IN(
            SELECT product_id, MAX(change_date)
            FROM product_prices
            WHERE change_date <= NOW()
            GROUP BY product_id)
        ORDER BY product_id DESC
    """)
    public List<ProductPrice> getActualPrices();
}
