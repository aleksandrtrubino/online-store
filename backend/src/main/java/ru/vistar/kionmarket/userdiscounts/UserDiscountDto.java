package ru.vistar.kionmarket.userdiscounts;

public class UserDiscountDto {
    private int value;
    private Long userId;
    public UserDiscountDto(){}

    public UserDiscountDto(int value, Long userId) {
        this.value = value;
        this.userId = userId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
