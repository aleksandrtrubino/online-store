package ru.vistar.kionmarket.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.vistar.kionmarket.product.Product;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.review.Review;
import ru.vistar.kionmarket.product.ProductDto;
import ru.vistar.kionmarket.product.ProductService;
import ru.vistar.kionmarket.product.ProductServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.create(productDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.update(id, productDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}/reviews")
    public ResponseEntity<Set<Review>> getReviews(@PathVariable Long id){
        return ResponseEntity.ok(productService.getReviews(id));
    }

    @GetMapping("/{id}/purchases")
    public ResponseEntity<Set<Purchase>> getPurchases(@PathVariable Long id){
        return ResponseEntity.ok(productService.getPurchases(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
