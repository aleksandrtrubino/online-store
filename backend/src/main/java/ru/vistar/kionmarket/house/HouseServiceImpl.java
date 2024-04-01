package ru.vistar.kionmarket.house;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.street.Street;
import ru.vistar.kionmarket.street.StreetRepository;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;
    private final StreetRepository streetRepository;

    public HouseServiceImpl(HouseRepository houseRepository, StreetRepository streetRepository) {
        this.houseRepository = houseRepository;
        this.streetRepository = streetRepository;
    }

    @Override
    public House create(HouseDto houseDto) {
        Street street = streetRepository.findById(houseDto.getStreet_id())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", houseDto.getStreet_id())));
        House house = new House();
        house.setNumber(houseDto.getNumber());
        house.setStreet(street);
        return houseRepository.save(house);
    }

    @Override
    public House update(Long houseId, HouseDto houseDto) {
        House house = houseRepository.findById(houseId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("House with id %1$s not found", houseId)));
        Street street = streetRepository.findById(houseDto.getStreet_id())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", houseDto.getStreet_id())));
        house.setNumber(houseDto.getNumber());
        house.setStreet(street);
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
