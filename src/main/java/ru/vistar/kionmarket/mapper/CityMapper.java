package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.City;
import ru.vistar.kionmarket.dto.CityDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {
    City toEntity(CityDto cityDto);
    CityDto toDto(City city);
    List<CityDto> toDto(List<City> cities);
}
