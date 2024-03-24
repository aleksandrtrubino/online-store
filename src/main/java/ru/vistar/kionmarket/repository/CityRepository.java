package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
