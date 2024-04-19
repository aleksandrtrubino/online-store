package ru.vistar.kionmarket.productdiscount;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-discounts")
public class ProductDiscountController {
    private final ProductDiscountService productDiscountService;

    public ProductDiscountController(ProductDiscountServiceImpl productDiscountService) {
        this.productDiscountService = productDiscountService;
    }

    @PostMapping
    public ResponseEntity<ProductDiscount> create(@RequestBody ProductDiscountDto productDiscountDto){
        return ResponseEntity.ok(productDiscountService.create(productDiscountDto));
    }
    @PutMapping("/{productDiscountId}")
    public ResponseEntity<ProductDiscount> update(@PathVariable Long productDiscountId, @RequestBody ProductDiscountDto productDiscountDto){
        return ResponseEntity.ok(productDiscountService.update(productDiscountId, productDiscountDto));
    }

    @GetMapping("/{productDiscountId}")
    public ResponseEntity<ProductDiscount> findById(@PathVariable Long productDiscountId){
        return ResponseEntity.ok(productDiscountService.findById(productDiscountId));
    }
    @GetMapping
    public ResponseEntity<List<ProductDiscount>> findAll(){
        return ResponseEntity.ok(productDiscountService.findAll());
    }
    @DeleteMapping("/{productDiscountId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long productDiscountId){
        productDiscountService.deleteById(productDiscountId);
        return ResponseEntity.ok().build();
    }
}
