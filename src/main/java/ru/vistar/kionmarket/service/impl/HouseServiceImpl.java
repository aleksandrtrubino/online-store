package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.House;
import ru.vistar.kionmarket.dto.HouseDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.HouseMapper;
import ru.vistar.kionmarket.repository.HouseRepository;
import ru.vistar.kionmarket.service.HouseService;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    final HouseRepository houseRepository;
    final HouseMapper houseMapper;

    public HouseServiceImpl(HouseRepository houseRepository, HouseMapper houseMapper) {
        this.houseRepository = houseRepository;
        this.houseMapper = houseMapper;
    }

    @Override
    public HouseDto create(HouseDto houseDto) {
        House house = houseMapper.toEntity(houseDto);
        return houseMapper.toDto(houseRepository.save(house));
    }

    @Override
    public HouseDto update(HouseDto houseDto) {
        House house = houseRepository.findById(houseDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", houseDto.getId())));
        house.setNumber(houseDto.getNumber());
        return houseMapper.toDto(houseRepository.save(house));
    }

    @Override
    public HouseDto findById(Long id) {
        House house = houseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", id)));
        return houseMapper.toDto(house);
    }

    @Override
    public List<HouseDto> findAll() {
        return houseMapper.toDto(houseRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        houseRepository.deleteById(id);
    }
}
