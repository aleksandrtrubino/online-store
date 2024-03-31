package ru.vistar.kionmarket.street;

public class StreetDto {

    private String name;

    public StreetDto(){}

    public StreetDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
