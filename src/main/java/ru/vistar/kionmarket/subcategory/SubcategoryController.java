package ru.vistar.kionmarket.subcategory;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.product.Product;


import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/subcategories")
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryServiceImpl subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    public ResponseEntity<Subcategory> create(@RequestBody SubcategoryDto subcategoryDto){
        return ResponseEntity.ok(subcategoryService.create(subcategoryDto));
    }

    @PutMapping("/{subcategoryId}")
    public ResponseEntity<Subcategory> update(@PathVariable Long subcategoryId, @RequestBody SubcategoryDto subcategoryDto){
        return ResponseEntity.ok(subcategoryService.update(subcategoryId, subcategoryDto));
    }

    @GetMapping("/{subcategoryId}")
    public ResponseEntity<Subcategory> findById(@PathVariable Long subcategoryId){
        return ResponseEntity.ok(subcategoryService.findById(subcategoryId));
    }

    @GetMapping
    public ResponseEntity<List<Subcategory>> findAll(){
        return ResponseEntity.ok(subcategoryService.findAll());
    }

    @DeleteMapping("/{subcategoryId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long subcategoryId){
        subcategoryService.deleteById(subcategoryId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{subcategoryId}/products")
    public ResponseEntity<Set<Product>> getProducts(@PathVariable Long subcategoryId){
        return ResponseEntity.ok(subcategoryService.getProducts(subcategoryId));
    }

}
