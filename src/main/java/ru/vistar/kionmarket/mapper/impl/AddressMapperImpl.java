package ru.vistar.kionmarket.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.AddressDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.*;
import ru.vistar.kionmarket.repository.AddressTypeRepository;
import ru.vistar.kionmarket.repository.CityRepository;
import ru.vistar.kionmarket.repository.HouseRepository;
import ru.vistar.kionmarket.repository.StreetRepository;

@Component
public class AddressMapperImpl implements AddressMapper {

    final AddressTypeRepository addressTypeRepository;
    final CityRepository cityRepository;
    final StreetRepository streetRepository;
    final HouseRepository houseRepository;

    public AddressMapperImpl(AddressTypeRepository addressTypeRepository, CityRepository cityRepository, StreetRepository streetRepository, HouseRepository houseRepository) {
        this.addressTypeRepository = addressTypeRepository;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
        this.houseRepository = houseRepository;
    }

    @Override
    public Address toEntity(AddressDto addressDto) {
        if ( addressDto == null ) {
            return null;
        }

        Address address = new Address();
        address.setId(addressDto.getId());
        AddressType addressType = addressTypeRepository.findById(addressDto.getAddressTypeId())
                        .orElseThrow(()->new ResourceNotFoundException(""));
        address.setAddressType(addressType);
        City city = cityRepository.findById(addressDto.getCityId())
                        .orElseThrow(()->new ResourceNotFoundException(""));
        address.setCity(city);
        Street street = streetRepository.findById(addressDto.getStreetId())
                        .orElseThrow(()->new ResourceNotFoundException(""));
        address.setStreet(street);
        House house = houseRepository.findById(addressDto.getHouseId())
                .orElseThrow(()->new ResourceNotFoundException(""));

        return address;
    }

    @Override
    public AddressDto toDto(Address address) {
        if ( address == null ) {
            return null;
        }

       AddressDto addressDto = new AddressDto();
       addressDto.setAddressTypeId(address.getAddressType().getId());
       addressDto.setCityId(address.getCity().getId());
       addressDto.setStreetId(address.getStreet().getId());
       addressDto.setHouseId(address.getHouse().getId());

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
