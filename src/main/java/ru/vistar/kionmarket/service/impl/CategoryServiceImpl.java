package ru.vistar.kionmarket.service.impl;

import org.springframework.stereotype.Service;
import ru.vistar.kionmarket.domain.Category;
import ru.vistar.kionmarket.dto.CategoryDto;
import ru.vistar.kionmarket.exception.ResourceNotFoundException;
import ru.vistar.kionmarket.mapper.CategoryMapper;
import ru.vistar.kionmarket.repository.CategoryRepository;
import ru.vistar.kionmarket.service.CategoryService;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryMapper categoryMapper;
    final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryMapper categoryMapper, CategoryRepository categoryRepository) {
        this.categoryMapper = categoryMapper;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        Category category = categoryMapper.toEntity(categoryDto);
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryDto.getId())
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", categoryDto.getId())));
        category.setName(categoryDto.getName());
        return categoryMapper.toDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto findById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException(String.format("Category with id %1$s not found", id)));
        return categoryMapper.toDto(category);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryMapper.toDto(categoryRepository.findAll());
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}
