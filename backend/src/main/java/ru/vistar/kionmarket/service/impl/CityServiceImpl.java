package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.City;
import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.repository.CityRepository;
import ru.vistar.kionmarket.service.CityService;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;

import java.util.List;
@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

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
    public City update(Long cityId, CityDto cityDto) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", cityId)));
        city.setName(cityDto.getName());
        return cityRepository.save(city);
    }

    @Override
    public City findById(Long cityId) {
        return cityRepository.findById(cityId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", cityId)));
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public void deleteById(Long cityId) {
        cityRepository.deleteById(cityId);
    }
}
