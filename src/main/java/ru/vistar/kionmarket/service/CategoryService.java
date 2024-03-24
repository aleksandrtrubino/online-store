package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    public CategoryDto create(CategoryDto categoryDto);
    public CategoryDto update(CategoryDto categoryDto);
    public CategoryDto findById(Long id);
    public List<CategoryDto> findAll();
    public void deleteById(Long id);
}
