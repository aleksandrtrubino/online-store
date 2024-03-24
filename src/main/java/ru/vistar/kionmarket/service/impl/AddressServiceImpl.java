package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.*;
import ru.vistar.kionmarket.dto.AddressDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.AddressMapper;
import ru.vistar.kionmarket.repository.*;
import ru.vistar.kionmarket.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    final AddressTypeRepository addressTypeRepository;
    final CityRepository cityRepository;
    final StreetRepository streetRepository;
    final HouseRepository houseRepository;
    final AddressRepository addressRepository;
    final AddressMapper addressMapper;

    public AddressServiceImpl(AddressTypeRepository addressTypeRepository, CityRepository cityRepository, StreetRepository streetRepository, HouseRepository houseRepository, AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressTypeRepository = addressTypeRepository;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
        this.houseRepository = houseRepository;
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDto create(Long addressTypeId, Long cityId, Long streetId, Long houseId) {
        AddressType addressType = addressTypeRepository.findById(addressTypeId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        City city = cityRepository.findById(cityId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        Street street = streetRepository.findById(streetId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        House house = houseRepository.findById(houseId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        Address address = new Address(city,street,house,addressType);
        return addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    public AddressDto update(Long addressId, Long addressTypeId, Long cityId, Long streetId, Long houseId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        AddressType addressType = addressTypeRepository.findById(addressTypeId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        City city = cityRepository.findById(cityId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        Street street = streetRepository.findById(streetId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        House house = houseRepository.findById(houseId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        address.setAddressType(addressType);
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        return addressMapper.toDto(addressRepository.save(address));
    }

    @Override
    public AddressDto findById(Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        return addressMapper.toDto(address);
    }

    @Override
    public List<AddressDto> findAll() {
        return addressMapper.toDto(addressRepository.findAll());
    }

    @Override
    public void deleteById(Long addressId) {
        addressRepository.deleteById(addressId);
    }
}
