package ru.vistar.kionmarket.shop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.product.Product;

import java.util.List;
import java.util.Set;
@RestController
@RequestMapping("/api/v1/shops")
public class ShopController {
    private final ShopService shopService;

    public ShopController(ShopServiceImpl shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    public ResponseEntity<Shop> create(@RequestBody ShopDto categoryDto){
        return ResponseEntity.ok(shopService.create(categoryDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> update(@PathVariable Long id, @RequestBody ShopDto categoryDto){
        return ResponseEntity.ok(shopService.update(id, categoryDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable Long id){
        return ResponseEntity.ok(shopService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Shop>> findAll(){
        return ResponseEntity.ok(shopService.findAll());
    }

    @GetMapping("/{id}/products")
    public ResponseEntity<Set<Product>> getSubcategories(@PathVariable Long id){
        return ResponseEntity.ok(shopService.getProducts(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        shopService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
