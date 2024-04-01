package ru.vistar.kionmarket.street;

public class StreetDto {

    private String name;
    private Long city_id;

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

    public Long getCity_id() {
        return city_id;
    }

    public void setCity_id(Long city_id) {
        this.city_id = city_id;
    }
}
