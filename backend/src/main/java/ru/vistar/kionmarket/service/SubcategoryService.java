package ru.vistar.kionmarket.service;

import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.dto.SubcategoryDto;
import ru.vistar.kionmarket.domain.Product;

import java.util.List;
import java.util.Set;

//subcategories
public interface SubcategoryService {
    public Subcategory create(SubcategoryDto subcategoryDto);// POST
    public Subcategory update(Long subcategoryId, SubcategoryDto subcategoryDto);//{subcategoryId} PUT
    public Subcategory findById(Long subcategoryId);//{subcategoryId} GET
    public List<Subcategory> findAll();// GET
    public void deleteById (Long subcategoryId);//{subcategoryId} DELETE

    public Set<Product> getProducts(Long subcategoryId);//{subcategoryId}/products
}
