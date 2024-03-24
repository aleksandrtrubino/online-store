package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.Street;
import ru.vistar.kionmarket.dto.StreetDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StreetMapper {
    Street toEntity(StreetDto streetDto);
    StreetDto toDto(Street street);
    List<StreetDto> toDto(List<Street> streets);
}
