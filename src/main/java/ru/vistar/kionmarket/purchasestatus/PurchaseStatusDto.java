package ru.vistar.kionmarket.purchasestatus;

public class PurchaseStatusDto {

    String name;

    public PurchaseStatusDto(){}

    public PurchaseStatusDto(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
