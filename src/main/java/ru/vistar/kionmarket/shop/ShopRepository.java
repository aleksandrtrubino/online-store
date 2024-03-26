package ru.vistar.kionmarket.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.vistar.kionmarket.shop.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
