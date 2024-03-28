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
        String name = categoryDto.getName();
        Category category = new Category(name);
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", categoryId)));
        category.setName(categoryDto.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", categoryId)));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void deleteById(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public Set<Subcategory> getSubcategories(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->new ResourceNotFoundException(String.format("Category with id %1$s not found", categoryId)));
        return category.getSubcategories();
    }
}
