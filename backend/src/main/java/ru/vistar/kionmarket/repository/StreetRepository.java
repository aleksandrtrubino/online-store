package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.Street;

@Repository
public interface StreetRepository extends JpaRepository<Street, Long> {
}
