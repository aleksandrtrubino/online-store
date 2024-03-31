package ru.vistar.kionmarket.review;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.review.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
