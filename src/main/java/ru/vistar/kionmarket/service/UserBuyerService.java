package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.UserBuyerDto;
import ru.vistar.kionmarket.dto.UserDto;

import java.util.List;

public interface UserBuyerService {
    public UserBuyerDto create(UserDto userDto, Long addressId);//users/buyers/addresses/{addressId}
    public UserBuyerDto update(UserDto userDto, Long addressId);//users/buyers/addresses/{addressId}
    public UserBuyerDto findById(Long userId);
    public List<UserBuyerDto> findAll();//users/buyers
    public void deleteById(Long userId);//users/buyers/{userId}
}
