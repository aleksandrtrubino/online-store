package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.AddressType;
import ru.vistar.kionmarket.dto.AddressTypeDto;

import java.util.List;
import java.util.Set;

public interface AddressTypeService {
    public AddressType create(AddressTypeDto addressTypeDto);//address-types
    public AddressType update(Long id, AddressTypeDto addressTypeDto);//address-types/{id}
    public AddressType findById(Long id);//address-types/{id}
    public List<AddressType> findAll();//address-types
    public void deleteById(Long id);//address-types/{id}

    public Set<Address> getAddresses(Long id);//address-types/{addressTypeId}/addresses/{addressId}
}
