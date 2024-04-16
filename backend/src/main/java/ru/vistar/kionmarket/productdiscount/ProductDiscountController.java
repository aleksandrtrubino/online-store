package ru.vistar.kionmarket.productdiscount;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product_discounts")
public class ProductDiscountController {
    private final ProductDiscountService productDiscountService;

    public ProductDiscountController(ProductDiscountServiceImpl productDiscountService) {
        this.productDiscountService = productDiscountService;
    }

    @PostMapping
    public ResponseEntity<ProductDiscount> create(@RequestBody ProductDiscountDto productDiscountDto){
        return ResponseEntity.ok(productDiscountService.create(productDiscountDto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDiscount> update(@PathVariable Long id, @RequestBody ProductDiscountDto productDiscountDto){
        return ResponseEntity.ok(productDiscountService.update(id, productDiscountDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDiscount> findById(@PathVariable Long id){
        return ResponseEntity.ok(productDiscountService.findById(id));
    }
    @GetMapping
    public ResponseEntity<List<ProductDiscount>> findAll(){
        return ResponseEntity.ok(productDiscountService.findAll());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        productDiscountService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
