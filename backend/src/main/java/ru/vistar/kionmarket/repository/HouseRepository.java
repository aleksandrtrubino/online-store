package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
