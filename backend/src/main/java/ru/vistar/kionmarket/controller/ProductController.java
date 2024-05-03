package ru.vistar.kionmarket.controller;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.vistar.kionmarket.domain.Purchase;
import ru.vistar.kionmarket.domain.Review;
import ru.vistar.kionmarket.dto.ProductRequestDto;
import ru.vistar.kionmarket.dto.ProductResponseDto;
import ru.vistar.kionmarket.service.ProductService;
import ru.vistar.kionmarket.service.impl.ProductServiceImpl;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;
    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create(@RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.create(productRequestDto));
    }

    @PostMapping("/images/{productId}")
    public ResponseEntity<String> uploadImage(@PathVariable Long productId, @RequestParam("file") MultipartFile[] images){
        productService.uploadProductImages(productId, images);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/images/{productId}")
    public ResponseEntity<List<byte[]>> getImage(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProductImages(productId));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> update(@PathVariable Long productId, @RequestBody ProductRequestDto productRequestDto){
        return ResponseEntity.ok(productService.update(productId, productRequestDto));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponseDto> findById(@PathVariable Long productId){
        return ResponseEntity.ok(productService.findById(productId));
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDto>> findAll(
            @RequestParam Integer page,
            @RequestParam Integer limit,
            @RequestParam String sort,
            @RequestParam String order,
            @RequestParam(required = false) Long category,
            @RequestParam(required = false) Long subcategory,
            @RequestParam(required = false) Integer priceFrom,
            @RequestParam(required = false) Integer priceTo,
            @RequestParam(required = false) Long shop,
            @RequestParam(required = false) String search){
        return ResponseEntity.ok(productService.findAll(page, limit,sort, order, category, subcategory,priceFrom,priceTo, shop, search));
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
