package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.domain.Subcategory;
import ru.vistar.kionmarket.dto.SubcategoryDto;
import ru.vistar.kionmarket.service.SubcategoryService;
import ru.vistar.kionmarket.service.impl.SubcategoryServiceImpl;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/subcategories")
public class SubcategoryController {
    final SubcategoryService subcategoryService;
    public SubcategoryController(SubcategoryServiceImpl subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    public ResponseEntity<Subcategory> create(@RequestBody SubcategoryDto subcategoryDto){
        return ResponseEntity.ok(subcategoryService.create(subcategoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subcategory> update(@PathVariable Long id, @RequestBody SubcategoryDto subcategoryDto){
        return ResponseEntity.ok(subcategoryService.update(id, subcategoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategory> findById(@PathVariable Long id){
        return ResponseEntity.ok(subcategoryService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Subcategory>> findAll(){
        return ResponseEntity.ok(subcategoryService.findAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Set<Product>> getProducts(@PathVariable Long id){
        return ResponseEntity.ok(subcategoryService.getProducts(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        subcategoryService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
