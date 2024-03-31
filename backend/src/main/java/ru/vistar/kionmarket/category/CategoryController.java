package ru.vistar.kionmarket.category;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.subcategory.Subcategory;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryServiceImpl categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.create(categoryDto));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<Category> update(@PathVariable Long categoryId, @RequestBody CategoryDto categoryDto){
        return ResponseEntity.ok(categoryService.update(categoryId, categoryDto));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<Category> findById(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.findById(categoryId));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok(categoryService.findAll());
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long categoryId){
        categoryService.deleteById(categoryId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{categoryId}/subcategories")
    public ResponseEntity<Set<Subcategory>> getSubcategories(@PathVariable Long categoryId){
        return ResponseEntity.ok(categoryService.getSubcategories(categoryId));
    }
}
