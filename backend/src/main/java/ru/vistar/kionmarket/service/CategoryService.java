package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Category;
import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.dto.CategoryDto;

import java.util.List;
import java.util.Set;

//categories
public interface CategoryService {
    public Category create(CategoryDto categoryDto);// POST
    public Category update(Long categoryId, CategoryDto categoryDto);//{categoryId}  PUT
    public Category findById(Long categoryId);//{categoryId} GET
    public List<Category> findAll();// GET
    public void deleteById(Long categoryId);//{categoryId} DELETE

    public Set<Subcategory> getSubcategories(Long categoryId);//{categoryId}/subcategories GET
}
