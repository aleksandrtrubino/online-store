package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Street;
import ru.vistar.kionmarket.dto.StreetDto;

import java.util.List;

public interface StreetService {
    public Street create(StreetDto streetDto);//addresses/streets
    public Street update(Long id, StreetDto streetDto);//addresses/streets/{streetId}
    public Street findById(Long id);//addresses/streets/{id}
    public List<Street> findAll();//addresses/streets
    public void deleteById(Long id);//addresses/streets/{id}
}
