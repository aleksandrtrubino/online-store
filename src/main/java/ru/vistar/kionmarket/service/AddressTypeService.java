package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.AddressTypeDto;

import java.util.List;

public interface AddressTypeService {
    public AddressTypeDto create(AddressTypeDto addressTypeDto);//addresses/types
    public AddressTypeDto update(AddressTypeDto addressTypeDto);//addresses/types
    public AddressTypeDto findById(Long id);//addresses/types/{id}
    public List<AddressTypeDto> findAll();//addresses/types
    public void deleteById(Long id);//addresses/types/{id}
}
