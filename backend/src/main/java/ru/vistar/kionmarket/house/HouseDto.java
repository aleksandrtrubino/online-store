package ru.vistar.kionmarket.house;

public class HouseDto {

    private String number;
    private Long street_id;

    public HouseDto(){}

    public HouseDto(String number, Long street_id) {
        this.number = number;
        this.street_id = street_id;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public Long getStreet_id() {
        return street_id;
    }
    public void setStreet_id(Long street_id) {
        this.street_id = street_id;
    }
}
