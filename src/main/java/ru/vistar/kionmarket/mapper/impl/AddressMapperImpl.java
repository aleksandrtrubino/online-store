package ru.vistar.kionmarket.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.dto.AddressDto;
import ru.vistar.kionmarket.mapper.*;


@Component
public class AddressMapperImpl implements AddressMapper {

    final AddressTypeMapper addressTypeMapper;
    final CityMapper cityMapper;
    final StreetMapper streetMapper;
    final HouseMapper houseMapper;

    public AddressMapperImpl(AddressTypeMapper addressTypeMapper, CityMapper cityMapper, StreetMapper streetMapper, HouseMapper houseMapper) {
        this.addressTypeMapper = addressTypeMapper;
        this.cityMapper = cityMapper;
        this.streetMapper = streetMapper;
        this.houseMapper = houseMapper;
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();
        address.setId(addressDto.getId());
        address.setAddressType(addressTypeMapper.toEntity(addressDto.getAddressTypeDto()));
        address.setCity(cityMapper.toEntity(addressDto.getCityDto()));
        address.setStreet(streetMapper.toEntity(addressDto.getStreetDto()));
        address.setHouse(houseMapper.toEntity(addressDto.getHouseDto()));

        return address;
    }

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDto addressDto = new AddressDto();
        addressDto.setId(address.getId());
        addressDto.setAddressTypeDto(addressTypeMapper.toDto(address.getAddressType()));
        addressDto.setCityDto(cityMapper.toDto(address.getCity()));
        addressDto.setStreetDto(streetMapper.toDto(address.getStreet()));
        addressDto.setHouseDto(houseMapper.toDto(address.getHouse()));

        return addressDto;
    }

    @Override
    public List<AddressDto> toDto(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDto> list = new ArrayList<AddressDto>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toDto( address ) );
        }

        return list;
    }
}
