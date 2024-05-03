package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.City;
import ru.vistar.kionmarket.repository.CityRepository;
import ru.vistar.kionmarket.repository.StreetRepository;
import ru.vistar.kionmarket.service.StreetService;
import ru.vistar.kionmarket.domain.Street;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.dto.StreetDto;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;
    private final CityRepository cityRepository;
    public StreetServiceImpl(StreetRepository streetRepository, CityRepository cityRepository) {
        this.streetRepository = streetRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Street create(StreetDto streetDto) {
        City city = cityRepository.findById(streetDto.getCity_id())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", streetDto.getCity_id())));
        Street street = new Street();
        street.setName(streetDto.getName());
        street.setCity(city);
        return streetRepository.save(street);
    }

    @Override
    public Street update(Long streetId, StreetDto streetDto) {
        Street street = streetRepository.findById(streetId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", streetId)));
        City city = cityRepository.findById(streetDto.getCity_id())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("City with id %1$s not found", streetDto.getCity_id())));
        street.setName(streetDto.getName());
        street.setCity(city);
        return streetRepository.save(street);
    }

    @Override
    public Street findById(Long streetId) {
        return streetRepository.findById(streetId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", streetId)));
    }

    @Override
    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    @Override
    public void deleteById(Long streetId) {
        streetRepository.deleteById(streetId);
    }
}
