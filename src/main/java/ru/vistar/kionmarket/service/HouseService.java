package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.AddressTypeDto;
import ru.vistar.kionmarket.dto.HouseDto;

import java.util.List;

public interface HouseService {
    public HouseDto create(HouseDto houseDto);//addresses/houses
    public HouseDto update(HouseDto houseDto);//addresses/houses
    public HouseDto findById(Long id);//addresses/houses/{id}
    public List<HouseDto> findAll();//addresses/houses
    public void deleteById(Long id);//addresses/houses/{id}
}
