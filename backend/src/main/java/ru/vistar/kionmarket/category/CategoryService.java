package ru.vistar.kionmarket.category;

import ru.vistar.kionmarket.subcategory.Subcategory;

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
