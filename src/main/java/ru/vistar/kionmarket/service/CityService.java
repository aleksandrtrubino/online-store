package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.dto.HouseDto;

import java.util.List;

public interface CityService {
    public CityDto create(CityDto cityDto);//addresses/cities
    public CityDto update(CityDto cityDto);//addresses/cities
    public CityDto findById(Long id);//addresses/cities/{id}
    public List<CityDto> findAll();//addresses/cities
    public void deleteById(Long id);//addresses/cities/{id}
}
