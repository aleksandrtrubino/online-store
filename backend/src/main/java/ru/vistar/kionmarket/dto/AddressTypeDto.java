package ru.vistar.kionmarket.dto;

public class AddressTypeDto {
    private String name;

    public AddressTypeDto(){}

    public AddressTypeDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
