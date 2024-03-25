package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.House;
import ru.vistar.kionmarket.dto.HouseDto;
import java.util.List;

public interface HouseService {
    public House create(HouseDto houseDto);//addresses/houses
    public House update(Long id, HouseDto houseDto);//addresses/houses/{id}
    public House findById(Long id);//addresses/houses/{id}
    public List<House> findAll();//addresses/houses
    public void deleteById(Long id);//addresses/houses/{id}
}
