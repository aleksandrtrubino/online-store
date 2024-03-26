package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Category;
import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.dto.CategoryDto;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    public Category create(CategoryDto categoryDto);
    public Category update(Long id, CategoryDto categoryDto);
    public Category findById(Long id);
    public List<Category> findAll();
    public void deleteById(Long id);
    public Set<Subcategory> getSubcategories(Long categoryId);//categories/{categoryId}/subcategories
}
