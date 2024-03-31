package ru.vistar.kionmarket.house;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

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
    public House update(Long houseId, HouseDto houseDto) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", houseId)));
        house.setNumber(houseDto.getNumber());
        return houseRepository.save(house);
    }

    @Override
    public House findById(Long houseId) {
        return houseRepository.findById(houseId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", houseId)));
    }

    @Override
    public List<House> findAll() {
        return houseRepository.findAll();
    }

    @Override
    public void deleteById(Long houseId) {
        houseRepository.deleteById(houseId);
    }
}
