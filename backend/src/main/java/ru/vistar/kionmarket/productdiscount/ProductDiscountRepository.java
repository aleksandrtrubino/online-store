package ru.vistar.kionmarket.productdiscount;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount, Long> {

    @Query(nativeQuery = true, value = """
    SELECT *
    FROM product_discounts
    WHERE (product_id, product_discount_id) IN (
        SELECT product_id, MAX(product_discount_id)
        FROM product_discounts
        WHERE start_date < NOW() AND end_date > NOW()
        GROUP BY product_id)
    ORDER BY product_id DESC
    """)
    public List<ProductDiscount> getActualDiscounts();
}
