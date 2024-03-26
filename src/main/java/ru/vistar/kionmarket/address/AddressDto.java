package ru.vistar.kionmarket.address;

public class AddressDto {
    private Long addressTypeId;
    private Long cityId;
    private Long streetId;
    private Long houseId;

    public AddressDto(){}

    public AddressDto(Long addressTypeId, Long cityId, Long streetId, Long houseId) {
        this.addressTypeId = addressTypeId;
        this.cityId = cityId;
        this.streetId= streetId;
        this.houseId = houseId;
    }

    public Long getAddressTypeId() {
        return addressTypeId;
    }

    public void setAddressTypeId(Long addressTypeId) {
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
}
