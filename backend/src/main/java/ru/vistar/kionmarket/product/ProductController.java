package ru.vistar.kionmarket.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.purchase.Purchase;
import ru.vistar.kionmarket.review.Review;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductServiceImpl productService;
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.create(productRequestDto));
    }

    @PostMapping("/images/{productId}")
    public ResponseEntity<String> uploadImage(@PathVariable Long productId, @RequestParam("file") MultipartFile[] images){
        productService.uploadProductImages(productId,images);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/images/{productId}")
    public ResponseEntity<List<byte[]>> getImage(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProductImages(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<Product> update(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.update(productId, productRequestDto));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<Product> findById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{productId}/reviews")
    public ResponseEntity<Set<Review>> getReviews(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getReviews(productId));
    }

    @GetMapping("/{productId}/purchases")
    public ResponseEntity<Set<Purchase>> getPurchases(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getPurchases(productId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
