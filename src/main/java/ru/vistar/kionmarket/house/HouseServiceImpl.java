package ru.vistar.kionmarket.house;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;

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
