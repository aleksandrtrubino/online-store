package ru.vistar.kionmarket.category;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.subcategory.Subcategory;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", id)));
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", id)));
        return category;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public Set<Subcategory> getSubcategories(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Category with id %1$s not found", id)));
        return category.getSubcategories();
    }
}
