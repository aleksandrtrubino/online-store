package ru.vistar.kionmarket.subcategory;

public class SubcategoryDto {

    private String name;

    private Long categoryId;

    public SubcategoryDto(){}

    public SubcategoryDto(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
