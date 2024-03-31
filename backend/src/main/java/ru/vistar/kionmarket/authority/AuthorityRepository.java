package ru.vistar.kionmarket.authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.authority.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
