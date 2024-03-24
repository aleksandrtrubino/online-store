package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.House;
import ru.vistar.kionmarket.dto.HouseDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface HouseMapper {
    House toEntity(HouseDto houseDto);
    HouseDto toDto(House house);
    List<HouseDto> toDto(List<House> houses);
}
