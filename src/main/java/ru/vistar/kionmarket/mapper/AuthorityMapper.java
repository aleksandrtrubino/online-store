package ru.vistar.kionmarket.mapper;

import ru.vistar.kionmarket.dto.AuthorityDto;
import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.Authority;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorityMapper {
    Authority toEntity(AuthorityDto authorityDto);
    AuthorityDto toDto(Authority authority);
    List<AuthorityDto> toDto(List<Authority> authorities);
}
