package ru.vistar.kionmarket.dto;

import ru.vistar.kionmarket.domain.Address;

public class UserBuyerDto {
    private UserDto userDto;
    private AddressDto addressDto;

    public UserBuyerDto(UserDto userDto, AddressDto addressDto) {
        this.userDto = userDto;
        this.addressDto = addressDto;
    }

    public UserBuyerDto() {
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public void setAddressDto(AddressDto addressDto) {
        this.addressDto = addressDto;
    }
}
