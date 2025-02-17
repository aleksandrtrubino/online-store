package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.AddressType;
import ru.vistar.kionmarket.dto.AddressTypeDto;

import java.util.List;
import java.util.Set;

//address-types
public interface AddressTypeService {

    public AddressType create(AddressTypeDto addressTypeDto);// POST
    public AddressType update(Long addressTypeId, AddressTypeDto addressTypeDto);//{addressTypeId} PUT
    public AddressType findById(Long addressTypeId);//{addressTypeId} GET
    public List<AddressType> findAll();//address-types GET
    public void deleteById(Long addressTypeId);//{addressTypeId} DELETE

    public Set<Address> getAddresses(Long addressTypeId);//{addressTypeId}/addresses/{addressId} GET
}
