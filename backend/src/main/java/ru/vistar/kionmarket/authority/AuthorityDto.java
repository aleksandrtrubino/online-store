package ru.vistar.kionmarket.authority;

public class AuthorityDto {
    private String name;

    public AuthorityDto(){}

    public AuthorityDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
