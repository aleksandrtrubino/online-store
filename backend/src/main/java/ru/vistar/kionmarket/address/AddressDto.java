package ru.vistar.kionmarket.address;

public class AddressDto {

    private Long houseId;
    private Long addressTypeId;

    public AddressDto(){}

    public AddressDto(Long houseId, Long addressTypeId) {
        this.houseId = houseId;
        this.addressTypeId = addressTypeId;
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
