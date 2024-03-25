package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.House;
import ru.vistar.kionmarket.dto.HouseDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.repository.HouseRepository;
import ru.vistar.kionmarket.service.HouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    final HouseRepository houseRepository;

    public HouseServiceImpl(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Override
    public House create(HouseDto houseDto) {
        House house = new House();
        house.setNumber(houseDto.getNumber());
        return houseRepository.save(house);
    }

    @Override
    public House update(Long id, HouseDto houseDto) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", id)));
        house.setNumber(houseDto.getNumber());
        return houseRepository.save(house);
    }

    @Override
    public House findById(Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", id)));
        return house;
    }

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        houseRepository.deleteById(id);
    }
}
