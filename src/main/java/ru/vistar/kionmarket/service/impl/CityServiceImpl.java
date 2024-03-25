package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.City;
import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.repository.CityRepository;
import ru.vistar.kionmarket.service.CityService;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City create(CityDto cityDto) {
        City city = new City();
        city.setName(cityDto.getName());
        return cityRepository.save(city);
    }

    @Override
    public City update(Long id, CityDto houseDto) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", id)));
        city.setName(city.getName());
        return cityRepository.save(city);
    }

    @Override
    public City findById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", id)));
        return city;
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
