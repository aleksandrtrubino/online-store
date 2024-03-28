package ru.vistar.kionmarket.house;

public class HouseDto {

    private String number;

    public HouseDto(){}

    public HouseDto(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
}
