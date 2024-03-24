package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.HouseDto;
import ru.vistar.kionmarket.dto.StreetDto;

import java.util.List;

public interface StreetService {
    public StreetDto create(StreetDto streetDto);//addresses/streets
    public StreetDto update(StreetDto streetDto);//addresses/streets
    public StreetDto findById(Long id);//addresses/streets/{id}
    public List<StreetDto> findAll();//addresses/streets
    public void deleteById(Long id);//addresses/streets/{id}
}
