package ru.vistar.kionmarket.house;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.house.House;

@Repository
public interface HouseRepository extends JpaRepository<House, Long> {
}
