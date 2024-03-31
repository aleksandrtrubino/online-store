package ru.vistar.kionmarket.street;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.street.Street;
import ru.vistar.kionmarket.street.StreetDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.street.StreetRepository;
import ru.vistar.kionmarket.street.StreetService;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    private final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public Street create(StreetDto streetDto) {
        String name = streetDto.getName();
        Street street = new Street(name);
        return streetRepository.save(street);
    }

    @Override
    public Street update(Long streetId, StreetDto streetDto) {
        Street street = streetRepository.findById(streetId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", streetId)));
        street.setName(streetDto.getName());
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
