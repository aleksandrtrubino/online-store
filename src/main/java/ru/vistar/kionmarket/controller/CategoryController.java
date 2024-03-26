package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.Category;
import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.dto.CategoryDto;
import ru.vistar.kionmarket.service.CategoryService;
import ru.vistar.kionmarket.service.impl.CategoryServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    final CategoryService categoryService;
    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.create(categoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.update(id, categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("/{id}/subcategories")
    public ResponseEntity<Set<Subcategory>> getSubcategories(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getSubcategories(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        categoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
