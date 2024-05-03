package ru.vistar.kionmarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.vistar.kionmarket.domain.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}
