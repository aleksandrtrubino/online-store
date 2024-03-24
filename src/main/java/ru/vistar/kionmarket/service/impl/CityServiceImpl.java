package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.City;
import ru.vistar.kionmarket.dto.CityDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.CityMapper;
import ru.vistar.kionmarket.repository.CityRepository;
import ru.vistar.kionmarket.service.CityService;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {

    final CityRepository cityRepository;
    final CityMapper cityMapper;

    public CityServiceImpl(CityRepository cityRepository, CityMapper cityMapper) {
        this.cityRepository = cityRepository;
        this.cityMapper = cityMapper;
    }

    @Override
    public CityDto create(CityDto cityDto) {
        City city = cityMapper.toEntity(cityDto);
        return cityMapper.toDto(cityRepository.save(city));
    }

    @Override
    public CityDto update(CityDto cityDto) {
        City city = cityRepository.findById(cityDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", cityDto.getId())));
        city.setName(cityDto.getName());
        return cityMapper.toDto(cityRepository.save(city));
    }

    @Override
    public CityDto findById(Long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", id)));
        return cityMapper.toDto(city);
    }

    @Override
    public List<CityDto> findAll() {
        return cityMapper.toDto(cityRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }
}
