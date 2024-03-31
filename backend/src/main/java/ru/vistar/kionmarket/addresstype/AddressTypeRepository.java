package ru.vistar.kionmarket.addresstype;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.addresstype.AddressType;

@Repository
public interface AddressTypeRepository extends JpaRepository<AddressType, Long> {
}
