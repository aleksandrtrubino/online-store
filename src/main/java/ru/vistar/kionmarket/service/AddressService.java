package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.AddressDto;

import java.util.List;

public interface AddressService {
    public AddressDto create(AddressDto addressDto);//addresses
    public AddressDto update(AddressDto addressDto);//addresses
    public AddressDto findById(Long addressId);//addresses/{addressId}
    public List<AddressDto> findAll();
    public void deleteById(Long addressId);
}
