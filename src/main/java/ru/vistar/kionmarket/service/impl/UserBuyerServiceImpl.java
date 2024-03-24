package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.UserBuyer;
import ru.vistar.kionmarket.dto.UserBuyerDto;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.UserBuyerMapper;
import ru.vistar.kionmarket.mapper.impl.UserBuyerMapperImpl;
import ru.vistar.kionmarket.repository.AddressRepository;
import ru.vistar.kionmarket.repository.UserBuyerRepository;
import ru.vistar.kionmarket.service.UserBuyerService;

import java.util.List;

@Service
public class UserBuyerServiceImpl implements UserBuyerService {

    final AddressRepository addressRepository;
    final UserBuyerRepository userBuyerRepository;
    final UserBuyerMapper userBuyerMapper;

    public UserBuyerServiceImpl(AddressRepository addressRepository, UserBuyerRepository userBuyerRepository, UserBuyerMapperImpl userBuyerMapper) {
        this.addressRepository = addressRepository;
        this.userBuyerRepository = userBuyerRepository;
        this.userBuyerMapper = userBuyerMapper;
    }

    @Override
    public UserBuyerDto create(UserDto userDto, Long addressId) {
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException(""));
        UserBuyer userBuyer = new UserBuyer();
        userBuyer.setPassword(userDto.getPassword());
        userBuyer.setEmail(userDto.getEmail());
        userBuyer.setFirstName(userDto.getFirstName());
        userBuyer.setMiddleName(userDto.getMiddleName());
        userBuyer.setLastName(userDto.getLastName());
        userBuyer.setAddress(address);
        return userBuyerMapper.toDto(userBuyerRepository.save(userBuyer));
    }

    @Override
    public UserBuyerDto update(UserDto userDto, Long addressId) {
        UserBuyer userBuyer = userBuyerRepository.findById(userDto.getId())
                .orElseThrow(()->new ResourceNotFoundException(""));
        Address address = addressRepository.findById(addressId)
                .orElseThrow(()-> new ResourceNotFoundException(""));
        userBuyer.setPassword(userDto.getPassword());
        userBuyer.setEmail(userDto.getEmail());
        userBuyer.setFirstName(userDto.getFirstName());
        userBuyer.setMiddleName(userDto.getMiddleName());
        userBuyer.setLastName(userDto.getLastName());
        userBuyer.setAddress(address);
        return userBuyerMapper.toDto(userBuyerRepository.save(userBuyer));
    }

    @Override
    public UserBuyerDto findById(Long userId){
        UserBuyer userBuyer = userBuyerRepository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException(""));
        return userBuyerMapper.toDto(userBuyer);
    }

    @Override
    public List<UserBuyerDto> findAll() {
        return userBuyerMapper.toDto(userBuyerRepository.findAll());
    }

    @Override
    public void deleteById(Long userId) {
        userBuyerRepository.deleteById(userId);
    }
}
