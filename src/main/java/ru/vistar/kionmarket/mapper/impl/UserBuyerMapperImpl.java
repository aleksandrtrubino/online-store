package ru.vistar.kionmarket.mapper.impl;

import org.springframework.stereotype.Component;
import ru.vistar.kionmarket.domain.Address;
import ru.vistar.kionmarket.domain.UserBuyer;
import ru.vistar.kionmarket.dto.AddressDto;
import ru.vistar.kionmarket.dto.UserBuyerDto;
import ru.vistar.kionmarket.dto.UserDto;
import ru.vistar.kionmarket.mapper.AddressMapper;
import ru.vistar.kionmarket.mapper.UserBuyerMapper;
import ru.vistar.kionmarket.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBuyerMapperImpl implements UserBuyerMapper {

    final UserMapper userMapper;
    final AddressMapper addressMapper;

    public UserBuyerMapperImpl(UserMapper userMapper, AddressMapper addressMapper) {
        this.userMapper = userMapper;
        this.addressMapper = addressMapper;
    }

    @Override
    public UserBuyer toEntity(UserBuyerDto userBuyerDto) {
        if(userBuyerDto == null)
            return null;
        UserBuyer userBuyer = (UserBuyer)userMapper.toEntity(userBuyerDto.getUserDto());
        Address address = addressMapper.toEntity(userBuyerDto.getAddressDto());
        userBuyer.setAddress(address);

        return userBuyer;
    }

    @Override
    public UserBuyerDto toDto(UserBuyer userBuyer) {
        if(userBuyer == null)
            return null;
        UserBuyerDto userBuyerDto = new UserBuyerDto();
        userBuyerDto.setUserDto(userMapper.toDto(userBuyer));
        userBuyerDto.setAddressDto(addressMapper.toDto(userBuyer.getAddress()));

        return userBuyerDto;
    }

    @Override
    public List<UserBuyerDto> toDto(List<UserBuyer> userBuyers) {
        if ( userBuyers == null ) {
            return null;
        }

        List<UserBuyerDto> list = new ArrayList<UserBuyerDto>( userBuyers.size() );
        for ( UserBuyer userBuyer : userBuyers ) {
            list.add( toDto( userBuyer ) );
        }

        return list;
    }
}
