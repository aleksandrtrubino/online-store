package ru.vistar.kionmarket.productprice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product-prices")
public class ProductPriceController {

    private final ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceServiceImpl productPriceService) {
        this.productPriceService = productPriceService;
    }

    @PostMapping
    public ResponseEntity<ProductPrice> create(@RequestBody ProductPriceDto productPriceDto){
        return ResponseEntity.ok(productPriceService.create(productPriceDto));
    }

    @PutMapping("/{productPriceId}")
    public ResponseEntity<ProductPrice> update(@PathVariable Long productPriceId, @RequestBody ProductPriceDto productPriceDto){
        return ResponseEntity.ok(productPriceService.update(productPriceId,productPriceDto));
    }

    @GetMapping("/{productPriceId}")
    public ResponseEntity<ProductPrice> findById(@PathVariable Long productPriceId){
        return ResponseEntity.ok(productPriceService.findById(productPriceId));
    }

    @GetMapping
    public ResponseEntity<List<ProductPrice>> findAll(){
        return ResponseEntity.ok(productPriceService.findAll());
    }

    @DeleteMapping("/{productPriceId}")
    public ResponseEntity<Void> deleteById(@PathVariable Long productPriceId){
        productPriceService.deleteById(productPriceId);
        return ResponseEntity.ok().build();
    }
}
