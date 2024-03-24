package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Street;
import ru.vistar.kionmarket.dto.StreetDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.StreetMapper;
import ru.vistar.kionmarket.repository.StreetRepository;
import ru.vistar.kionmarket.service.StreetService;

import java.util.List;

@Service
public class StreetServiceImpl implements StreetService {

    final StreetMapper streetMapper;
    final StreetRepository streetRepository;

    public StreetServiceImpl(StreetMapper streetMapper, StreetRepository streetRepository) {
        this.streetMapper = streetMapper;
        this.streetRepository = streetRepository;
    }

    @Override
    public StreetDto create(StreetDto streetDto) {
        Street street = streetMapper.toEntity(streetDto);
        return streetMapper.toDto(streetRepository.save(street));
    }

    @Override
    public StreetDto update(StreetDto streetDto) {
        Street street = streetRepository.findById(streetDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found",streetDto.getId())));
        street.setName(streetDto.getName());
        return streetMapper.toDto(streetRepository.save(street));
    }

    @Override
    public StreetDto findById(Long id) {
        Street street = streetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Street with id %1$s not found", id)));
        return streetMapper.toDto(street);
    }

    @Override
    public List<StreetDto> findAll() {
        return streetMapper.toDto(streetRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        streetRepository.deleteById(id);
    }
}
