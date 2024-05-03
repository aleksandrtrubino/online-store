package ru.vistar.kionmarket.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.domain.Shop;
import ru.vistar.kionmarket.service.ShopService;
import ru.vistar.kionmarket.service.impl.ShopServiceImpl;
import ru.vistar.kionmarket.domain.Product;
import ru.vistar.kionmarket.dto.ShopDto;

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

    @PutMapping("/{shopId}")
    public ResponseEntity<Shop> update(@PathVariable Long shopId, @RequestBody ShopDto categoryDto){
        return ResponseEntity.ok(shopService.update(shopId, categoryDto));
    }

    @GetMapping("/{shopId}")
    public ResponseEntity<Shop> findById(@PathVariable Long shopId){
        return ResponseEntity.ok(shopService.findById(shopId));
    }

    @GetMapping
    public ResponseEntity<List<Shop>> findAll(){
        return ResponseEntity.ok(shopService.findAll());
    }

    @DeleteMapping("/{shopId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long shopId){
        shopService.deleteById(shopId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{shopId}/products")
    public ResponseEntity<Set<Product>> getSubcategories(@PathVariable Long shopId){
        return ResponseEntity.ok(shopService.getProducts(shopId));
    }


}
