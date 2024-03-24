package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public AddressDto create(Long addressTypeId, Long cityId, Long streetId, Long houseId);//addresses/types/{addressTypeId}/cities/{cityId}/streets/{streetId}/houses/{houseId}
    public AddressDto update(Long addressId, Long addressTypeId, Long cityId, Long streetId, Long houseId);//addresses/{addressId}/types/{addressTypeId}/cities/{cityId}/streets/{streetId}/houses/{houseId}
    public AddressDto findById(Long addressId);//addresses/{addressId}
    public List<AddressDto> findAll();//addresses
    public void deleteById(Long addressId);//addresses/{addressId}

}
