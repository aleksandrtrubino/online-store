package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.AddressType;
import ru.vistar.kionmarket.dto.AddressTypeDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.AddressTypeMapper;
import ru.vistar.kionmarket.repository.AddressTypeRepository;
import ru.vistar.kionmarket.service.AddressTypeService;

import java.util.List;

@Service
public class AddressTypeServiceImpl implements AddressTypeService {

    final AddressTypeRepository addressTypeRepository;
    final AddressTypeMapper addressTypeMapper;

    public AddressTypeServiceImpl(AddressTypeRepository addressTypeRepository, AddressTypeMapper addressTypeMapper) {
        this.addressTypeRepository = addressTypeRepository;
        this.addressTypeMapper = addressTypeMapper;
    }

    @Override
    public AddressTypeDto create(AddressTypeDto addressTypeDto) {
        AddressType addressType = addressTypeMapper.toEntity(addressTypeDto);
        return addressTypeMapper.toDto(addressTypeRepository.save(addressType));
    }

    @Override
    public AddressTypeDto update(AddressTypeDto addressTypeDto) {
        AddressType addressType = addressTypeRepository.findById(addressTypeDto.getId())
                .orElseThrow(()->new ResourceNotFoundException(String.format("AddressType with id %1$s not found",addressTypeDto.getId())));
        addressType.setName(addressTypeDto.getName());
        return addressTypeMapper.toDto(addressTypeRepository.save(addressType));
    }

    @Override
    public AddressTypeDto findById(Long id) {
        AddressType addressType = addressTypeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("AddressType with id %1$s not found",id)));
        return addressTypeMapper.toDto(addressType);
    }

    @Override
    public List<AddressTypeDto> findAll() {
        return addressTypeMapper.toDto(addressTypeRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        addressTypeRepository.deleteById(id);
    }
}
