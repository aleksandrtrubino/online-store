package ru.vistar.kionmarket.city;

import org.springframework.stereotype.Service;
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
    public City update(Long id, CityDto cityDto) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", id)));
        city.setName(cityDto.getName());
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
