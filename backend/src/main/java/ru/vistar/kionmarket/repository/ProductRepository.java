package ru.vistar.kionmarket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.vistar.kionmarket.domain.Product;


public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

//    @Query(value = "SELECT * FROM USERS WHERE LASTNAME = ?1",
//            countQuery = "SELECT count(*) FROM USERS WHERE LASTNAME = ?1",
//            nativeQuery = true)
//    Page<User> findByLastname(String lastname, Pageable pageable);

    @Query(value = "SELECT COUNT(r.id) FROM Review r WHERE r.product.id = :productId")
    public int getReviewCountByProductId(@Param("productId") Long productId);


    @Query(value = "SELECT AVG(r.rating) FROM Review r WHERE r.product.id = :productId")
    public Double getAverageRatingByProductId(@Param("productId") Long productId);
}
