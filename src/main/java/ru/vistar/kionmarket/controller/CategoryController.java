package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.dto.CategoryDto;
import ru.vistar.kionmarket.service.CategoryService;
import ru.vistar.kionmarket.service.impl.CategoryServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    final CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.create(categoryDto));
    }
    @PutMapping
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.update(categoryDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
