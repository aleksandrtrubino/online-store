package ru.vistar.kionmarket.address;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.address.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
}
