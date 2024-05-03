package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.AddressType;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
}
