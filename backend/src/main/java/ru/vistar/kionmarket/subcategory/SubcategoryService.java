package ru.vistar.kionmarket.subcategory;

import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.subcategory.Subcategory;
import ru.vistar.kionmarket.subcategory.SubcategoryDto;

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
