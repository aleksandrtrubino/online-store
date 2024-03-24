package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.AddressType;
import ru.vistar.kionmarket.dto.AddressTypeDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressTypeMapper {
    AddressType toEntity(AddressTypeDto addressTypeDto);
    AddressTypeDto toDto(AddressType addressType);
    List<AddressTypeDto> toDto(List<AddressType> addressTypes);
}
