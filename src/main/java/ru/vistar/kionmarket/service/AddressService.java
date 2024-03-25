package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public Address create(AddressDto addressDto);//addresses
    public Address update(Long id, AddressDto addressDto);//addresses/{addressesId}
    public Address findById(Long addressId);//addresses/{addressId}
    public List<Address> findAll();//addresses
    public void deleteById(Long addressId);//addresses/{addressId}
}
