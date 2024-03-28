package ru.vistar.kionmarket.address;

public class AddressDto {

    private Long cityId;
    private Long streetId;
    private Long houseId;
    private Long addressTypeId;

    public AddressDto(){}

    public AddressDto(Long cityId, Long streetId, Long houseId, Long addressTypeId) {
        this.cityId = cityId;
        this.streetId = streetId;
        this.houseId = houseId;
        this.addressTypeId = addressTypeId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getStreetId() {
        return streetId;
    }

    public void setStreetId(Long streetId) {
        this.streetId = streetId;
    }

    public Long getHouseId() {
        return houseId;
    }

    public void setHouseId(Long houseId) {
        this.houseId = houseId;
    }

    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
        this.addressTypeId = addressTypeId;
    }
}
