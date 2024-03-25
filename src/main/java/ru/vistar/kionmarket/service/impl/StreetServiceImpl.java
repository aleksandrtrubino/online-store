package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Street;
import ru.vistar.kionmarket.dto.StreetDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.repository.StreetRepository;
import ru.vistar.kionmarket.service.StreetService;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    final StreetRepository streetRepository;

    public StreetServiceImpl(StreetRepository streetRepository) {
        this.streetRepository = streetRepository;
    }

    @Override
    public Street create(StreetDto streetDto) {
        Street street = new Street();
        street.setName(streetDto.getName());
        return streetRepository.save(street);
    }

    @Override
    public Street update(Long id, StreetDto streetDto) {
        Street street = streetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", id)));
        street.setName(streetDto.getName());
        return streetRepository.save(street);
    }

    @Override
    public Street findById(Long id) {
        Street street = streetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", id)));
        return street;
    }

    @Override
    public List<Street> findAll() {
        return streetRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        streetRepository.deleteById(id);
    }
}
