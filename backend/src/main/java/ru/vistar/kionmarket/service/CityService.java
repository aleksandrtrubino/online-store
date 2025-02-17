package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.domain.City;

import java.util.List;


//cities
public interface CityService {
    public City create(CityDto cityDto);// POST
    public City update(Long cityId, CityDto cityDto);//{cityId} PUT
    public City findById(Long cityId);//{cityId} GET
    public List<City> findAll();// GET
    public void deleteById(Long cityId);//{cityId} DELETE
}
