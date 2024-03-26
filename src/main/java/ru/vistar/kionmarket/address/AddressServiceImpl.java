package ru.vistar.kionmarket.address;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.addresstype.AddressType;
import ru.vistar.kionmarket.addresstype.AddressTypeRepository;
import ru.vistar.kionmarket.city.City;
import ru.vistar.kionmarket.city.CityRepository;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.house.House;
import ru.vistar.kionmarket.house.HouseRepository;
import ru.vistar.kionmarket.street.Street;
import ru.vistar.kionmarket.street.StreetRepository;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final AddressTypeRepository addressTypeRepository;
    private final CityRepository cityRepository;
    private final StreetRepository streetRepository;
    private final HouseRepository houseRepository;
    public AddressServiceImpl(AddressRepository addressRepository, AddressTypeRepository addressTypeRepository, CityRepository cityRepository, StreetRepository streetRepository, HouseRepository houseRepository) {
        this.addressRepository = addressRepository;
        this.addressTypeRepository = addressTypeRepository;
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
        this.houseRepository = houseRepository;
    }

    @Override
    public Address create(AddressDto addressDto) {
        AddressType addressType = addressTypeRepository.findById(addressDto.getAddressTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressDto.getAddressTypeId())));
        City city = cityRepository.findById(addressDto.getCityId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", addressDto.getCityId())));
        Street street = streetRepository.findById(addressDto.getStreetId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", addressDto.getStreetId())));
        House house = houseRepository.findById(addressDto.getHouseId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", addressDto.getHouseId())));
        Address address = new Address();
        address.setAddressType(addressType);
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        return addressRepository.save(address);
    }

    @Override
    public Address update(Long id, AddressDto addressDto) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Address with id %1$s not found", id)));
        AddressType addressType = addressTypeRepository.findById(addressDto.getAddressTypeId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("AddressType with id %1$s not found", addressDto.getAddressTypeId())));
        City city = cityRepository.findById(addressDto.getCityId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", addressDto.getCityId())));
        Street street = streetRepository.findById(addressDto.getStreetId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", addressDto.getStreetId())));
        House house = houseRepository.findById(addressDto.getHouseId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", addressDto.getHouseId())));
        address.setAddressType(addressType);
        address.setCity(city);
        address.setStreet(street);
        address.setHouse(house);
        return addressRepository.save(address);
    }

    @Override
    public Address findById(Long id) {
        Address address = addressRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Address with id %1$s not found", id)));
        return address;
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
