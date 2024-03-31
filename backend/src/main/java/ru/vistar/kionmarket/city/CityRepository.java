package ru.vistar.kionmarket.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.city.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
