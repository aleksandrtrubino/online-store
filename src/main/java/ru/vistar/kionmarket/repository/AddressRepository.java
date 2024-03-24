package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
