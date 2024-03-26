package ru.vistar.kionmarket.address;

import ru.vistar.kionmarket.address.Address;
import ru.vistar.kionmarket.address.AddressDto;

import java.util.List;

public interface AddressService {
    public Address create(AddressDto addressDto);//addresses
    public Address update(Long id, AddressDto addressDto);//addresses/{addressesId}
    public Address findById(Long addressId);//addresses/{addressId}
    public List<Address> findAll();//addresses
    public void deleteById(Long addressId);//addresses/{addressId}
}
