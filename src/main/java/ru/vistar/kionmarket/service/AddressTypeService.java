package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.dto.AddressTypeDto;

import java.util.List;

public interface AddressTypeService {
    public AddressTypeDto create(AddressTypeDto addressTypeDto);//address-types
    public AddressTypeDto update(AddressTypeDto addressTypeDto);//address-types
    public AddressTypeDto findById(Long id);//address-types/{id}
    public List<AddressTypeDto> findAll();//address-types
    public void deleteById(Long id);//address-types/{id}

    //public List<Address> getAddresses(Long addressTypeId, Long addressId);//address-types/{addressTypeId}/addresses/{addressId}
}
