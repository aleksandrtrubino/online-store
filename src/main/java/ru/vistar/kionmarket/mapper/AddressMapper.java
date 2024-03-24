package ru.vistar.kionmarket.mapper;

import org.mapstruct.Mapper;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.dto.AddressDto;

import java.util.List;

public interface AddressMapper {
    Address toEntity(AddressDto addressDto);
    AddressDto toDto(Address address);
    List<AddressDto> toDto(List<Address> addresses);
}
