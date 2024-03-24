package ru.vistar.kionmarket.dto;


public class AddressDto {
    private Long id;
    private AddressTypeDto addressTypeDto;
    private CityDto cityDto;
    private StreetDto streetDto;
    private HouseDto houseDto;

    public AddressDto(){}

    public AddressDto(Long id, AddressTypeDto addressTypeDto, CityDto cityDto, StreetDto streetDto, HouseDto houseDto) {
        this.id = id;
        this.addressTypeDto = addressTypeDto;
        this.cityDto = cityDto;
        this.streetDto = streetDto;
        this.houseDto = houseDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AddressTypeDto getAddressTypeDto() {
        return addressTypeDto;
    }

    public void setAddressTypeDto(AddressTypeDto addressTypeDto) {
        this.addressTypeDto = addressTypeDto;
    }

    public CityDto getCityDto() {
        return cityDto;
    }

    public void setCityDto(CityDto cityDto) {
        this.cityDto = cityDto;
    }

    public StreetDto getStreetDto() {
        return streetDto;
    }

    public void setStreetDto(StreetDto streetDto) {
        this.streetDto = streetDto;
    }

    public HouseDto getHouseDto() {
        return houseDto;
    }

    public void setHouseDto(HouseDto houseDto) {
        this.houseDto = houseDto;
    }
}
