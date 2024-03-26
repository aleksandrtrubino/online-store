package ru.vistar.kionmarket.category;

import ru.vistar.kionmarket.subcategory.Subcategory;

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
