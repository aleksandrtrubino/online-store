package ru.vistar.kionmarket.address;

import java.util.List;

public interface AddressService {
    public Address create(AddressDto addressDto);// POST
    public Address update(Long addressId, AddressDto addressDto);//{addressesId} PUT
    public Address findById(Long addressId);//{addressId} GET
    public List<Address> findAll();// GET
    public void deleteById(Long addressId);//{addressId} DELETE
}
