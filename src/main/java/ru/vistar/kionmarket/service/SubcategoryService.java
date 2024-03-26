package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.dto.SubcategoryDto;

import java.util.List;
import java.util.Set;

public interface SubcategoryService {
    public Subcategory create(SubcategoryDto subcategoryDto);
    public Subcategory update(Long id, SubcategoryDto subcategoryDto);
    public Subcategory findById(Long id);
    public List<Subcategory> findAll();
    public void deleteById (Long id);
    public Set<Product> getProducts(Long id);
}
