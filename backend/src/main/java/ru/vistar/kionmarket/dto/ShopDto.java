package ru.vistar.kionmarket.dto;

public class ShopDto {

    private String name;

    ShopDto(){}

    public ShopDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
