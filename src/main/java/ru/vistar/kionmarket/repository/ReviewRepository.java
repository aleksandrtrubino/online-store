package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
