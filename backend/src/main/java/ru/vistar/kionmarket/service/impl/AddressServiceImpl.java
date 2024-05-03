package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.House;
import ru.vistar.kionmarket.repository.HouseRepository;
import ru.vistar.kionmarket.domain.AddressType;
import ru.vistar.kionmarket.dto.AddressDto;
import ru.vistar.kionmarket.repository.AddressRepository;
import ru.vistar.kionmarket.repository.AddressTypeRepository;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.service.AddressService;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressTypeRepository addressTypeRepository;
    private final HouseRepository houseRepository;
    public AddressServiceImpl(AddressRepository addressRepository, AddressTypeRepository addressTypeRepository, HouseRepository houseRepository) {
        this.addressRepository = addressRepository;
        this.addressTypeRepository = addressTypeRepository;
        this.houseRepository = houseRepository;
    }

    @Override
    public Address create(AddressDto addressDto) {
        AddressType addressType = addressTypeRepository.findById(addressDto.getAddressTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressDto.getAddressTypeId())));
        House house = houseRepository.findById(addressDto.getHouseId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", addressDto.getHouseId())));
        Address address = new Address(house,addressType);
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long addressId, AddressDto addressDto) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Address with id %1$s not found", addressId)));
        AddressType addressType = addressTypeRepository.findById(addressDto.getAddressTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressDto.getAddressTypeId())));
        House house = houseRepository.findById(addressDto.getHouseId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", addressDto.getHouseId())));
        address.setAddressType(addressType);
        address.setHouse(house);
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Address with id %1$s not found", id)));
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }
}
