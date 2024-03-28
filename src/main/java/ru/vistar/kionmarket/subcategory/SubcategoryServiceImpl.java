package ru.vistar.kionmarket.subcategory;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.category.Category;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.category.CategoryRepository;

import java.util.List;
import java.util.Set;

@Service
public class SubcategoryServiceImpl implements SubcategoryService {

    private final SubcategoryRepository subcategoryRepository;

    private final CategoryRepository categoryRepository;
    public SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository, CategoryRepository categoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Subcategory create(SubcategoryDto subcategoryDto) {
        String name = subcategoryDto.getName();
        Category category = categoryRepository.findById(subcategoryDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Category with id %1$s not found",subcategoryDto.getCategoryId())));

        Subcategory subcategory = new Subcategory(name, category);
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Subcategory update(Long subcategoryId, SubcategoryDto subcategoryDto) {
        Subcategory subcategory = subcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", subcategoryId)));
        Category category = categoryRepository.findById(subcategoryDto.getCategoryId())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Category with id %1$s not found",subcategoryDto.getCategoryId())));
        subcategory.setName(subcategoryDto.getName());
        subcategory.setCategory(category);
        return subcategoryRepository.save(subcategory);
    }

    @Override
    public Subcategory findById(Long subcategoryId) {
        return subcategoryRepository.findById(subcategoryId)
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", subcategoryId)));
    }

    @Override
    public List<Subcategory> findAll() {
        return subcategoryRepository.findAll();
    }

    @Override
    public void deleteById(Long subcategoryId) {
        subcategoryRepository.deleteById(subcategoryId);
    }

    @Override
    public Set<Product> getProducts(Long subcategoryId) {
        Subcategory subcategory = subcategoryRepository.findById(subcategoryId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Subcategory with id %1$s not found", subcategoryId)));
        return subcategory.getProducts();
    }
}
