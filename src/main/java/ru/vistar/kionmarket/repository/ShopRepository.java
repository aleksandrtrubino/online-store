package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.domain.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
